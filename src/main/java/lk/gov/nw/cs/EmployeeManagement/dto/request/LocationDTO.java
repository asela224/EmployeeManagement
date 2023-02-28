package lk.gov.nw.cs.EmployeeManagement.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocationDTO {


    private int locationId;
    private String province;
    private String district;
    private String agaDivision;
    private String gnDivision;
    private String villageAurStreet;


}
