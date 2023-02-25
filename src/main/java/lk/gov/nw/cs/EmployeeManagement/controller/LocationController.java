package lk.gov.nw.cs.EmployeeManagement.controller;

import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.service.LocationService;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/location")
@CrossOrigin
public class LocationController {

    @Autowired
    LocationService locationService;

    @Value("${configuration.pagination.elementsPerPage}")
    private int pageSize;

    @GetMapping(value = "/getAvailableLocations/page/{page}")
    public ResponseEntity<StandardResponse> getPaginatedLocations(@PathVariable(value = "page") int page){

      return  locationService.getLocationPage(page,pageSize);


    }

    @GetMapping(value = "/getOULocations/organizationalUnit/{organizationalUnit}/page/{page}")
    public ResponseEntity<StandardResponse> getPaginatedLocationsByOrganizationalUnit(@PathVariable(value = "organizationalUnit") String organizationalUnit,@PathVariable(value = "page")  int page){

        return null;
    }

    public ResponseEntity<StandardResponse> getPaginatedFilteredLocationsByOrganizationalUnit(String organizationalUnit,String filter, int page){

        return null;
    }


    public ResponseEntity<StandardResponse> getLocationById(int locationId){

        return null;
    }

    public ResponseEntity<StandardResponse> getLocationByName(int page){

        return null;
    }

    ///////////////////////////////

    public ResponseEntity<StandardResponse> AddNewLocation(EmployeeRequestDTO employeeRequestDTO){

        return null;
    }

    public ResponseEntity<StandardResponse> updateLocation(int locationId){

        return null;
    }

}
