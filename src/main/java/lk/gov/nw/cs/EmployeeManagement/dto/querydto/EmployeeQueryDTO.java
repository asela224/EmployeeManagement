package lk.gov.nw.cs.EmployeeManagement.dto.querydto;

import lk.gov.nw.cs.EmployeeManagement.dto.request.InstituteDTO;
import lk.gov.nw.cs.EmployeeManagement.dto.request.LocationDTO;
import lk.gov.nw.cs.EmployeeManagement.entity.Institute;
import lk.gov.nw.cs.EmployeeManagement.util.previousInstitute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class EmployeeQueryDTO {

    private int employeeId;
    private String name;
    private String nic;
    private String designation;
    private List<previousInstitute> previousInstituteList;
    private String permanentAddress;
    private String instituteName;
    private List<String> contactNumbers;
    private String province;
    private String district;
    private String agaDivision;
    private String gnDivision;
    private String villageAurStreet;

}
