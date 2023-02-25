package lk.gov.nw.cs.EmployeeManagement.dto.request;


import lk.gov.nw.cs.EmployeeManagement.util.enums.InstituteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class InstituteDTO {

        private int instituteId;
        private String instituteName;
        private String oic;
        private InstituteType instituteType;
        private int parentInstituteId;
        private boolean activeStatus;

}
