package lk.gov.nw.cs.EmployeeManagement.advisor;

import lk.gov.nw.cs.EmployeeManagement.exception.DataNotFoundException;
import lk.gov.nw.cs.EmployeeManagement.exception.DuplicateEntryException;
import lk.gov.nw.cs.EmployeeManagement.exception.InputNotInCorrectFormatException;
import lk.gov.nw.cs.EmployeeManagement.util.StandardResponse;
import org.springframework.dao.DuplicateKeyException;
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
    @ExceptionHandler(InputNotInCorrectFormatException.class)
    public ResponseEntity<StandardResponse> inputNotInCorrectFormatExceptionHandler(InputNotInCorrectFormatException inputNotInCorrectFormatException){


        return new ResponseEntity<StandardResponse>(new StandardResponse
                (406,
                        "failed Validate Data",
                            inputNotInCorrectFormatException.getMessage(),0,null)
                , HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<StandardResponse> DuplicateKeyExceptionHandler(DuplicateEntryException duplicateEntryException){


        return new ResponseEntity<StandardResponse>(new StandardResponse
                (202,
                        "failed Validate Data",
                        duplicateEntryException.getMessage(), 0,null)
                , HttpStatus.NOT_ACCEPTABLE);

    }


}
