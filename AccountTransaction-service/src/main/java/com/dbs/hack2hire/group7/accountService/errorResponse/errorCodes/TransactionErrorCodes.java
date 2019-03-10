package com.dbs.hack2hire.group7.accountService.errorResponse.errorCodes;

public enum TransactionErrorCodes {



    CREATE_TRANSACTION_ERROR(1001, "Sorry, your transaction failed"),
    VOILATION_TRANSACTION(1002,"Voilation during transaction");


    private final int id;
    private final String message;

    TransactionErrorCodes(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
    
}
