package lk.gov.nw.cs.EmployeeManagement.dto.request;


import com.sun.istack.NotNull;
import lk.gov.nw.cs.EmployeeManagement.entity.Employee;
import lk.gov.nw.cs.EmployeeManagement.entity.EmployeePersonal;
import lk.gov.nw.cs.EmployeeManagement.entity.Institute;
import lk.gov.nw.cs.EmployeeManagement.util.previousInstitute;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;




@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequestDTO {
    private int employeeId;
    private String name;
    private String nic;
    private String designation;
    private Date appointedDateToCurrentDesignation;
    private Date transferDateToCurrentPermanentWorkPlace;
    private InstituteDTO currentInstitute;
    private List<previousInstitute> previousInstituteList;
    private String permanentAddress;
    private LocationDTO location;
    private List<String> contactNumbers;

}
