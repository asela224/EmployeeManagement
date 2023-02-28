package lk.gov.nw.cs.EmployeeManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.InputMismatchException;
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InputNotInCorrectFormatException extends InputMismatchException {

    public InputNotInCorrectFormatException(String message){
        super(message);


    }

}
