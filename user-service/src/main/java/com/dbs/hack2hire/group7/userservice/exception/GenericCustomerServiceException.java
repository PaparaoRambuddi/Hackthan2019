package com.dbs.hack2hire.group7.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericCustomerServiceException extends RuntimeException {
    protected List<String> errorMessages;
    protected Integer errorCode;
}
