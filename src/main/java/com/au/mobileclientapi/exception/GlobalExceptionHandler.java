package com.au.mobileclientapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleBadRequestException(ConstraintViolationException ex, WebRequest request) {

        StringBuilder exceptionMessage = new StringBuilder();
        ex.getConstraintViolations().stream()
                .forEach((violation) -> exceptionMessage.append(violation.getMessage()));

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                                                                .code(String.format("API-%s", HttpStatus.BAD_REQUEST.value()))
                                                                .message(exceptionMessage.toString()).build();


        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {



       ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .code(String.format("API-%s", HttpStatus.NOT_FOUND.value()))
                .message(ex.getMessage()).build();


        return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);


    }

}
