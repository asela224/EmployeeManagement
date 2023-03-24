package lk.gov.nw.cs.EmployeeManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class DuplicateEntryException extends RuntimeException{
  public  DuplicateEntryException(String mesage){
        super(mesage);


    }

}
