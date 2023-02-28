package lk.gov.nw.cs.EmployeeManagement.service.impl;

import lk.gov.nw.cs.EmployeeManagement.dto.request.LocationDTO;
import lk.gov.nw.cs.EmployeeManagement.entity.Location;
import lk.gov.nw.cs.EmployeeManagement.exception.DataNotFoundException;
import lk.gov.nw.cs.EmployeeManagement.exception.InputNotInCorrectFormatException;
import lk.gov.nw.cs.EmployeeManagement.repository.LocationRepository;
import lk.gov.nw.cs.EmployeeManagement.service.LocationService;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import lk.gov.nw.cs.EmployeeManagement.util.enums.LocationFilter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceIMPL implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<StandardResponse> getLocationPage(int page, int pageSize) {

       Page<Location> locations = locationRepository.findAll(PageRequest.of(page,pageSize,Sort.by("locationId").ascending()));

       List<LocationDTO> locationResponseDTOList =modelMapper.map(locations.toList(),new TypeToken<List<LocationDTO>>(){}.getType());

       if (locationResponseDTOList.size()>0) {
           return new ResponseEntity<StandardResponse>(
                   new StandardResponse(200, "success", "Data loaded Successfully.",locationResponseDTOList.size() ,locationResponseDTOList), HttpStatus.OK);
       }
       else{
           throw new DataNotFoundException("Error while getting  location data for page number: "+page);
       }

    }

    @Override
    public ResponseEntity<StandardResponse> getLocationListOf(LocationFilter locationFilter,String parameter, int page, int pageSize) {

        Page<Location> locations ;
        switch (locationFilter) {
            case PROVINCE:
                locations = locationRepository.findAllByProvinceEqualsIgnoreCase(parameter, PageRequest.of(page, pageSize,Sort.by("locationId").ascending()));
                break;

            case DISTRICT:
                locations = locationRepository.findAllByDistrictEqualsIgnoreCase(parameter, PageRequest.of(page, pageSize,Sort.by("locationId").ascending()));
                break;
            case AGA_DIVISION:
                locations = locationRepository.findAllByAgaDivisionLikeIgnoreCase("%" + parameter + "%", PageRequest.of(page, pageSize,Sort.by("locationId").ascending()));
                break;
            case GN_DIVISION:
                locations = locationRepository.findAllByGnDivisionLikeIgnoreCase("%" + parameter + "%", PageRequest.of(page, pageSize,Sort.by("locationId").ascending()));
                break;

            case VILLAGE_OR_STREET:
                locations = locationRepository.findAllByVillageAurStreetLikeIgnoreCase("%" + parameter + "%", PageRequest.of(page, pageSize,Sort.by("locationId").ascending()));
                break;

            default:
                throw new InputNotInCorrectFormatException("Input Location Filter was not in Correct Format");

        }

       List<LocationDTO> locationDTOList =modelMapper.map(locations.toList(),new TypeToken<List<LocationDTO>>(){}.getType());
        if (locationDTOList.size()>0) {
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "success", "Data loaded Successfully.", locationDTOList.size() , locationDTOList), HttpStatus.OK);
        }
        else{
            throw new DataNotFoundException("Error while getting filtered  location data for page number: "+page);
        }

    }

    @Override
    public ResponseEntity<StandardResponse> saveLocation(LocationDTO locationDTO) {

        try {
            Location location = modelMapper.map(locationDTO, Location.class);

            location = locationRepository.save(location);
            locationDTO.setLocationId(location.getLocationId());


            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(201, "success", "Data Inserted Successfully.", 1, locationDTO), HttpStatus.CREATED);

        }catch(Exception e){
            throw new InputNotInCorrectFormatException("Input Not in Correct Format for insert Location");
        }
    }

    @Override
    public ResponseEntity<StandardResponse> getLocationById(int locationId) {
        Optional<Location> location = locationRepository.findById(locationId);

        if (location.isPresent()) {
            LocationDTO locationDTO = modelMapper.map(location, LocationDTO.class);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,
                            "success",
                            "Data fetched Successfully.",
                            1,
                            locationDTO), HttpStatus.OK);
        }else {

            throw new DataNotFoundException("There is no location belongs to id: "+locationId+", in the Database ");
        }


    }

    @Override
    public ResponseEntity<StandardResponse> updateLocation(LocationDTO locationDTO) {
        Optional<Location> location = locationRepository.findById(locationDTO.getLocationId());
        if (location.isPresent()) {
            Location updatedLocation = modelMapper.map(locationDTO, Location.class);
            locationRepository.save(updatedLocation);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(201, "success", "Data Updated Successfully.", 1, locationDTO), HttpStatus.ACCEPTED);

        } else {
            throw new DataNotFoundException("Couldn't find Existing Location Record to update with id: " + locationDTO.getLocationId());
        }


    }


}
