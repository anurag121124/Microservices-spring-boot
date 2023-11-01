package com.userservice.exceptions;

import com.userservice.payloads.ApiResposne;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<ApiResposne> handlerResourceNotFoundException(ResourceNotFoundExceptions ex){

        String message = ex.getMessage();
      ApiResposne resposne= ApiResposne.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
      return new ResponseEntity<>(resposne,HttpStatus.NOT_FOUND);

    }

}
