package com.tucasa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<?>> handleValidationException(MethodArgumentNotValidException ex){

        List<String> errors = new ArrayList<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            String errorMessage = error.getField() + " : " + error.getDefaultMessage();

            errors.add(errorMessage);
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
