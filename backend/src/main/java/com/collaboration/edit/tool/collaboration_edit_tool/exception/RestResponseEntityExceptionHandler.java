package com.collaboration.edit.tool.collaboration_edit_tool.exception;



import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value=ResourceNotFoundException.class)
    public ResponseEntity<Object> noElementFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value=EmptyResponseBodyException.class)
    public ResponseEntity<Object> emptyResponseBody(EmptyResponseBodyException ex){
        return new ResponseEntity<>(ex.errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=EmptyFieldsException.class)
    public ResponseEntity<List<String>> emptyFieldsException(EmptyFieldsException ex){
        return new ResponseEntity<>(ex.errors, HttpStatus.BAD_REQUEST);
    }
    
}
