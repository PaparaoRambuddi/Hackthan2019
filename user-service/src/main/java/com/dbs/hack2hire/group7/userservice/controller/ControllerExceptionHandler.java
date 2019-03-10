package com.dbs.hack2hire.group7.userservice.controller;

import com.dbs.hack2hire.group7.userservice.dto.ErrorDTO;
import com.dbs.hack2hire.group7.userservice.exception.CustomerNotFoundException;
import com.dbs.hack2hire.group7.userservice.exception.NotEnoughRedemptionPointsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler{
    @ExceptionHandler({ CustomerNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleCustomerNotFoundException(CustomerNotFoundException e){
        return ResponseEntity.status(e.getErrorCode()).body(new ErrorDTO(e.getErrorCode(),e.getErrorMessages()));
    }
    @ExceptionHandler({ NotEnoughRedemptionPointsException.class})
    public ResponseEntity<ErrorDTO> NotEnoughRedemptionPointsException(NotEnoughRedemptionPointsException e){
        return ResponseEntity.status(e.getErrorCode()).body(new ErrorDTO(e.getErrorCode(),e.getErrorMessages()));
    }
}
