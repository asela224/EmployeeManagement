package lk.gov.nw.cs.EmployeeManagement.service.impl;

import lk.gov.nw.cs.EmployeeManagement.dto.request.InstituteDTO;
import lk.gov.nw.cs.EmployeeManagement.dto.request.LocationDTO;
import lk.gov.nw.cs.EmployeeManagement.entity.Institute;
import lk.gov.nw.cs.EmployeeManagement.entity.Location;
import lk.gov.nw.cs.EmployeeManagement.exception.DataNotFoundException;
import lk.gov.nw.cs.EmployeeManagement.exception.InputNotInCorrectFormatException;
import lk.gov.nw.cs.EmployeeManagement.repository.InstituteRepository;
import lk.gov.nw.cs.EmployeeManagement.repository.LocationRepository;
import lk.gov.nw.cs.EmployeeManagement.service.InstituteService;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstituteServiceIMPL implements InstituteService {
    @Autowired
    InstituteRepository instituteRepository;

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<StandardResponse> getInstituteById(int instituteId) {
        Optional<Institute> institute = instituteRepository.findById(instituteId);

        if (institute.isPresent()) {
            InstituteDTO instituteDTO = modelMapper.map(institute, InstituteDTO.class);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,
                            "success",
                            "Data fetched Successfully.",
                            1,
                            instituteDTO), HttpStatus.OK);
        }else {

            throw new DataNotFoundException("There is no Institute belongs to id: "+instituteId+", in the Database ");
        }


    }

    @Override
    public ResponseEntity<StandardResponse> saveInstitute(InstituteDTO instituteDTO) {


        try {
            Institute institute = modelMapper.map(instituteDTO, Institute.class);
            institute.setParentInstitute(instituteRepository.getReferenceById(instituteDTO.getParentInstituteId()));
            institute.setLocation(locationRepository.getReferenceById(instituteDTO.getLocationId()));

            institute = instituteRepository.save(institute);
            instituteDTO.setInstituteId(institute.getInstituteId());


            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(201, "success", "Data Inserted Successfully.", 1, instituteDTO), HttpStatus.CREATED);

        }catch(Exception e){
            throw new InputNotInCorrectFormatException("Input Not in Correct Format for insert Institute");
        }


    }

    @Override
    public ResponseEntity<StandardResponse> updateInstitute(InstituteDTO instituteDTO) {
        Optional<Institute> institute = instituteRepository.findById(instituteDTO.getInstituteId());
        if (institute.isPresent()) {
            Institute updatedInstitute = modelMapper.map(instituteDTO, Institute.class);
            instituteRepository.save(updatedInstitute);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(201, "success", "Data Updated Successfully.", 1, instituteDTO), HttpStatus.ACCEPTED);

        } else {
            throw new DataNotFoundException("Couldn't find Existing Institute Record to update with id: " + instituteDTO.getInstituteId());
        }
    }
}
