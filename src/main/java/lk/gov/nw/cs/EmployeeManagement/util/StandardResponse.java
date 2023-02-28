package lk.gov.nw.cs.EmployeeManagement.util;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {


        private int code;
        private String status;
        private String message;
        private int dataCount;
        private Object data;



    }


