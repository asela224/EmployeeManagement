package lk.gov.nw.cs.EmployeeManagement.util;

import javafx.beans.DefaultProperty;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

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


