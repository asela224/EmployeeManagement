package lk.gov.nw.cs.EmployeeManagement.controller;

import lk.gov.nw.cs.EmployeeManagement.dto.request.InstituteDTO;
import lk.gov.nw.cs.EmployeeManagement.service.InstituteService;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/institute/")
@CrossOrigin
public class InstituteController {

    @Autowired
    InstituteService instituteService;

    @Value("${configuration.pagination.elementsPerPage}")
    private int pageSize;


    @GetMapping(value = "getInstitute/InstituteId/{id}")
    public ResponseEntity<StandardResponse> getInstituteById(@PathVariable(value = "id") int instituteId){

        return  instituteService.getInstituteById(instituteId);
    }

    ///////////////////////////////

    @PostMapping(value = "saveInstitute")
    public ResponseEntity<StandardResponse> AddNewInstitute(InstituteDTO instituteDTO){

        return instituteService.saveInstitute(instituteDTO);
    }

    @PutMapping(value = "updateInstitute")
    public ResponseEntity<StandardResponse> updateInstitute(InstituteDTO instituteDTO){

        return instituteService.updateInstitute(instituteDTO);
    }




}
