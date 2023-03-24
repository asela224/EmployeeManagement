package lk.gov.nw.cs.EmployeeManagement.dto.request;


import lk.gov.nw.cs.EmployeeManagement.entity.Location;
import lk.gov.nw.cs.EmployeeManagement.util.enums.InstituteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;


@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class InstituteDTO {

        private int instituteId;
        private String instituteName;
        private String oic;
        private InstituteType instituteType;
        private int parentInstituteId;
        private String postalAddress;
        private List<String> contactNumbers;
        private String email;
        private int locationId;
        private boolean activeStatus;
}
