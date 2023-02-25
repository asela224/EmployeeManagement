package lk.gov.nw.cs.EmployeeManagement.service.impl;

import lk.gov.nw.cs.EmployeeManagement.dto.response.LocationResponseDTO;
import lk.gov.nw.cs.EmployeeManagement.entity.Location;
import lk.gov.nw.cs.EmployeeManagement.exception.DataNotFoundException;
import lk.gov.nw.cs.EmployeeManagement.repository.LocationRepository;
import lk.gov.nw.cs.EmployeeManagement.service.LocationService;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceIMPL implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<StandardResponse> getLocationPage(int page, int pageSize) {

       Page<Location> locations = locationRepository.findAll(PageRequest.of(page,pageSize));

       List<LocationResponseDTO> locationResponseDTOList =modelMapper.map(locations.toList(),new TypeToken<List<LocationResponseDTO>>(){}.getType());

       if (locationResponseDTOList.size()>0) {
           return new ResponseEntity<StandardResponse>(
                   new StandardResponse(200, "success", "Data loaded Successfully.",locationResponseDTOList.size() ,locationResponseDTOList), HttpStatus.OK);
       }
       else{
           throw new DataNotFoundException("Error while getting  location data for page number: "+page);
       }

    }
}
