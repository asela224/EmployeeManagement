package lk.gov.nw.cs.EmployeeManagement.dto.request;


import lk.gov.nw.cs.EmployeeManagement.dto.response.LocationResponseDTO;
import lk.gov.nw.cs.EmployeeManagement.util.previousInstitute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;




@Data
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
    private LocationResponseDTO location;
    private List<String> contactNumbers;

}
