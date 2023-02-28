package lk.gov.nw.cs.EmployeeManagement.controller;

import lk.gov.nw.cs.EmployeeManagement.dto.request.LocationDTO;
import lk.gov.nw.cs.EmployeeManagement.service.LocationService;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import lk.gov.nw.cs.EmployeeManagement.util.enums.LocationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/location/")
@CrossOrigin
public class LocationController {

    @Autowired
    LocationService locationService;

    @Value("${configuration.pagination.elementsPerPage}")
    private int pageSize;

    @GetMapping(value = "getAvailableLocations/page/{page}")
    public ResponseEntity<StandardResponse> getPaginatedLocations(@PathVariable(value = "page") int page){

      return  locationService.getLocationPage(page,pageSize);


    }

    @GetMapping(value = "getLocations/filter/{locationtype}/parameter/{parameter}/page/{page}")
    public ResponseEntity<StandardResponse> getPaginatedLocationsByOrganizationalUnit(@PathVariable(value = "locationtype") LocationFilter locationFilter, @PathVariable(value = "parameter") String parameter, @PathVariable(value = "page")  int page){

        return  locationService.getLocationListOf(locationFilter,parameter,page,pageSize);
    }

    @GetMapping(value = "getLocations/locationId/{id}")
    public ResponseEntity<StandardResponse> getLocationById(@PathVariable(value = "id") int locationId){

        return  locationService.getLocationById(locationId);
    }

    ///////////////////////////////

    @PostMapping(value = "saveLocation")
    public ResponseEntity<StandardResponse> AddNewLocation(LocationDTO locationDTO){

        return locationService.saveLocation(locationDTO);
    }

   @PutMapping(value = "updateLocation")
    public ResponseEntity<StandardResponse> updateLocation(LocationDTO locationDTO){

       return locationService.updateLocation(locationDTO);
    }



}
