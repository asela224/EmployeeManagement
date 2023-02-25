package lk.gov.nw.cs.EmployeeManagement.service;

import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.springframework.http.ResponseEntity;

public interface LocationService {


    ResponseEntity<StandardResponse> getLocationPage(int page, int pageSize);
}
