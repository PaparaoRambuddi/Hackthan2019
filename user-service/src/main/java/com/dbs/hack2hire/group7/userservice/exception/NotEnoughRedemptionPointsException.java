package com.dbs.hack2hire.group7.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ResponseStatus(value= HttpStatus.EXPECTATION_FAILED, reason="Customer not found")
public class NotEnoughRedemptionPointsException extends RuntimeException {
    private List<String> errorMessages;
    private Integer errorCode;
}
