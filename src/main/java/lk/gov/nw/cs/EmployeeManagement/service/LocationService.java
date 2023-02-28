package lk.gov.nw.cs.EmployeeManagement.service;

import lk.gov.nw.cs.EmployeeManagement.dto.request.LocationDTO;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import lk.gov.nw.cs.EmployeeManagement.util.enums.LocationFilter;
import org.springframework.http.ResponseEntity;

public interface LocationService {


    ResponseEntity<StandardResponse> getLocationPage(int page, int pageSize);

   ResponseEntity<StandardResponse> getLocationListOf(LocationFilter locationFilter,String parameter, int page, int pageSize);

    ResponseEntity<StandardResponse> saveLocation(LocationDTO locationDTO);

    ResponseEntity<StandardResponse> getLocationById(int locationId);


    ResponseEntity<StandardResponse> updateLocation(LocationDTO locationDTO);
}
