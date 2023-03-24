package lk.gov.nw.cs.EmployeeManagement.service.impl;

import lk.gov.nw.cs.EmployeeManagement.configuration.mappers.EmployeeMapper;
import lk.gov.nw.cs.EmployeeManagement.dto.querydto.EmployeeQueryDTO;
import lk.gov.nw.cs.EmployeeManagement.dto.querydto.EmployeeQueryInterface;
import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeSaveRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.dto.request.LocationDTO;
import lk.gov.nw.cs.EmployeeManagement.entity.Employee;
import lk.gov.nw.cs.EmployeeManagement.entity.EmployeePersonal;
import lk.gov.nw.cs.EmployeeManagement.exception.DataNotFoundException;
import lk.gov.nw.cs.EmployeeManagement.exception.DuplicateEntryException;
import lk.gov.nw.cs.EmployeeManagement.repository.EmployeePersonalRepository;
import lk.gov.nw.cs.EmployeeManagement.repository.EmployeeRepository;
import lk.gov.nw.cs.EmployeeManagement.repository.InstituteRepository;
import lk.gov.nw.cs.EmployeeManagement.repository.LocationRepository;
import lk.gov.nw.cs.EmployeeManagement.service.EmployeeService;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.hibernate.annotations.SQLInsert;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeePersonalRepository employeePersonalRepository;

    @Autowired
    InstituteRepository instituteRepository;

    @Autowired
    LocationRepository locationRepository;

    @Override
    public ResponseEntity<StandardResponse> getEmployeeById(int employeeId) {

        Employee employee=employeeRepository.getReferenceById(employeeId);
        EmployeeRequestDTO employeeRequestDTO=modelMapper.map(employee, EmployeeRequestDTO.class);

        EmployeePersonal employeePersonal=employeePersonalRepository.getReferenceById(employeeId);
        employeeRequestDTO.setContactNumbers(employeePersonal.getContactNumbers());
        employeeRequestDTO.setLocation(modelMapper.map(employeePersonal.getLocation(), LocationDTO.class));
        employeeRequestDTO.setPermanentAddress(employeePersonal.getPermanentAddress());

        return null;

    }

    @Override
    @Transactional
    public ResponseEntity<StandardResponse> saveEmployee(EmployeeSaveRequestDTO employeeSaveRequestDTO){

        try {
            Employee employee=new Employee() ;
            EmployeePersonal employeePersonal=new EmployeePersonal();
            //Validate if Already Exists
            if (!employeeRepository.existsEmployeeByNicEqualsIgnoreCase(employeeSaveRequestDTO.getNic())) {

                System.out.println("Entered");
                //Map to Entity and Save record in First Table
                employee = modelMapper.map(employeeSaveRequestDTO, Employee.class);
                employee.setEmployeeId(0);
                employee.setCurrentInstitute(instituteRepository.getReferenceById(employeeSaveRequestDTO.getCurrentInstituteId()));

                 employee=employeeRepository.save(employee);

                //Map DTO data to Employee Personal Entity
                 //employeePersonal = modelMapper.map(employeeSaveRequestDTO, EmployeePersonal.class);
                employeePersonal=employeeMapper.employeeSaveRequestDTO_TO_EmployeePersonal(employeeSaveRequestDTO);

                //Prepare Second Table record with first record ID
               // employeePersonal.setEmployeeId(employee.getEmployeeId());
                employeePersonal.setEmployee(employee);
                System.out.println(employeePersonal.getEmployeeId());

                //get Location from ID
                System.out.println("Location Id >> ready to fetch"+employeeSaveRequestDTO.getLocationId());
                employeePersonal.setLocation(locationRepository.getReferenceById(employeeSaveRequestDTO.getLocationId()));
                System.out.println("Location Id >> fetched District >> "+employeePersonal.getLocation().getDistrict());
                System.out.println("Personal Id >> fetched emp Id >> "+employeePersonal.getEmployeeId());


                //Save Second Record too
                employeePersonal = employeePersonalRepository.save(employeePersonal);
                //===================================================================//
                // Saved Completed
                //===================================================================//

                //Prepare DTO to make Output Data
                EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();
                employeeRequestDTO = modelMapper.map(employee, EmployeeRequestDTO.class);

                employeeRequestDTO.setContactNumbers(employeePersonal.getContactNumbers());
                employeeRequestDTO.setLocation(modelMapper.map(employeePersonal.getLocation(), LocationDTO.class));
                employeeRequestDTO.setPermanentAddress(employeePersonal.getPermanentAddress());

                //Return as Application Standard
                return new ResponseEntity<StandardResponse>(
                        new StandardResponse(201,
                                "Created",
                                "Employee Saved Successfully.",
                                1,
                                employeeRequestDTO), HttpStatus.CREATED);


            } else {
                //Handle
                throw new DuplicateEntryException("Duplicate Entry Found with NIC: " + employeeSaveRequestDTO.getNic());
            }

        }catch (Exception e) {
            throw new DataNotFoundException("Referencing Data Records Must be Unavailable ==>> "+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<StandardResponse> updateEmployee(EmployeeRequestDTO employeeRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<StandardResponse> getPaginatedEmployeeListOfInstitute(int InstituteId, int page, int pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<StandardResponse> UpdateEmployee(EmployeeRequestDTO employeeRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<StandardResponse> getEmployeeByNic(String nic) {

        //Ask
        Optional<Employee> employee=   employeeRepository.getEmployeeByNicEqualsIgnoreCase(nic);

        //Check
        if (employee.isPresent()) {

            //Prepare to Serve
            EmployeeRequestDTO employeeRequestDTO = modelMapper.map(employee.get(), EmployeeRequestDTO.class);

            //Serve in Standard Manner
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,
                            "success",
                            "Data fetched Successfully.",
                            1,
                            employeeRequestDTO), HttpStatus.OK);
        }else {
            //Handle
            throw new DataNotFoundException("There is no Employee belongs to NIC: "+nic+", in the Database ");
        }



    }

    @Override
    public ResponseEntity<StandardResponse> getEmployees(int page, int pageSize) {

        //Request a Page by calling Custom Query Method
       // List<EmployeeQueryInterface> employees=employeeRepository.getEmployeeList();
        Page<EmployeeQueryInterface> employees=employeeRepository.getEmployeePage(PageRequest.of(page, pageSize));
        //Model Mapper Convert Interface to DTO
        Page<EmployeeQueryDTO> employeeQueryDTO=modelMapper.map(employees,new TypeToken<Page<EmployeeQueryDTO>>(){}.getType());

        //Prepare and Return
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,
                        "success",
                        "Data fetched Successfully.",
                        (int)employeeRepository.count(),
                        employeeQueryDTO), HttpStatus.OK);
    }


}
