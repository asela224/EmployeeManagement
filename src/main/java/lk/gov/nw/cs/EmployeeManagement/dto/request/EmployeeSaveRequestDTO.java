package lk.gov.nw.cs.EmployeeManagement.dto.request;

import lk.gov.nw.cs.EmployeeManagement.util.previousInstitute;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeSaveRequestDTO {


    private String name;
    private String nic;
    private String designation;
    private Date appointedDateToCurrentDesignation;
    private Date transferDateToCurrentPermanentWorkPlace;
    private int currentInstituteId;
    private String permanentAddress;
    private int locationId;
    private List<String> contactNumbers;

}
