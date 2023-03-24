package lk.gov.nw.cs.EmployeeManagement.service;

import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeSaveRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<StandardResponse> getEmployeeById(int employeeId);

    ResponseEntity<StandardResponse> saveEmployee(EmployeeSaveRequestDTO employeeSaveRequestDTO);

    ResponseEntity<StandardResponse> updateEmployee(EmployeeRequestDTO employeeRequestDTO);

    ResponseEntity<StandardResponse> getPaginatedEmployeeListOfInstitute(int InstituteId, int page, int pageSize);


    ResponseEntity<StandardResponse> UpdateEmployee(EmployeeRequestDTO employeeRequestDTO);

    ResponseEntity<StandardResponse> getEmployeeByNic(String nic);

    ResponseEntity<StandardResponse> getEmployees(int page, int pageSize);
}
