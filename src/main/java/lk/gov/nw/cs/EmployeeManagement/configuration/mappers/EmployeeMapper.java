package lk.gov.nw.cs.EmployeeManagement.configuration.mappers;

import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeSaveRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.entity.EmployeePersonal;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeePersonal employeeSaveRequestDTO_TO_EmployeePersonal(EmployeeSaveRequestDTO employeeSaveRequestDTOS);

}
