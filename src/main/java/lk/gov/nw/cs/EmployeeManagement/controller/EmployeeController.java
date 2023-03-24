package lk.gov.nw.cs.EmployeeManagement.controller;

import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeSaveRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.entity.EmployeePersonal;
import lk.gov.nw.cs.EmployeeManagement.entity.Institute;
import lk.gov.nw.cs.EmployeeManagement.service.EmployeeService;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import lk.gov.nw.cs.EmployeeManagement.util.previousInstitute;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee/")

public class EmployeeController {

    @Value("${configuration.pagination.elementsPerPage}")
    private int pageSize;
    @Autowired
    EmployeeService  employeeService;

    @PostMapping(value = "save")
    public ResponseEntity<StandardResponse> saveEmployee(@RequestBody EmployeeSaveRequestDTO employeeSaveRequestDTO  ){
        return employeeService.saveEmployee(employeeSaveRequestDTO);
    }

    @PutMapping(value = "update")
    public ResponseEntity<StandardResponse> updateEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO  ) {
        return employeeService.UpdateEmployee(employeeRequestDTO);
    }

    @GetMapping(value = "institute-id/{institute-id}/page/{page}")
    public ResponseEntity<StandardResponse> getPaginatedEmployeeListOfInstitute(@PathVariable (name = "institute-id")int instituteId,@PathVariable(name = "page") int page ){
        return employeeService.getPaginatedEmployeeListOfInstitute(instituteId,page,pageSize );
    }

    @GetMapping(value = "getEmployeeByNic/{nic}")
    public ResponseEntity<StandardResponse> getmployeeByInstitute(@PathVariable String nic){
        return employeeService.getEmployeeByNic(nic );
    }
    @GetMapping(value = "getEmployees/page/{page}")
    public ResponseEntity<StandardResponse> getmployees(@PathVariable int page){
        return employeeService.getEmployees(page,pageSize);
    }

}
