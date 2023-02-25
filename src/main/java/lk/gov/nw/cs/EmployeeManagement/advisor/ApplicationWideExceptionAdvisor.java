package lk.gov.nw.cs.EmployeeManagement.advisor;

import lk.gov.nw.cs.EmployeeManagement.exception.DataNotFoundException;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationWideExceptionAdvisor {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<StandardResponse> dataNotFoundExceptionHandler(DataNotFoundException dataNotFoundException){


        return new ResponseEntity<StandardResponse>(new StandardResponse
                                                        (404,
                                                        "failed Load Data",
                                                                dataNotFoundException.getMessage(),0,null)
                                                , HttpStatus.NOT_FOUND);

    }
}