package lk.gov.nw.cs.EmployeeManagement.service;

import lk.gov.nw.cs.EmployeeManagement.dto.request.InstituteDTO;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.springframework.http.ResponseEntity;

public interface InstituteService {
    ResponseEntity<StandardResponse> getInstituteById(int instituteId);

    ResponseEntity<StandardResponse> saveInstitute(InstituteDTO instituteDTO);

    ResponseEntity<StandardResponse> updateInstitute(InstituteDTO instituteDTO);
}
