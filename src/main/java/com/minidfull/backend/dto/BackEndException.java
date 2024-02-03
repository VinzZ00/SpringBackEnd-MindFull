package com.minidfull.backend.dto;

public class BackEndException extends RuntimeException {
    public BackEndException(String message) {
        super(message);
    }


    public static BackEndException notFoundException(String className) {
        String message = String.format("There is no row of %s found with the id you provided", className);

        return new BackEndException(message);
    }

    public static BackEndException SpringServerLogicalError(String className) {
        return new BackEndException("this message is generated for the Coder, no Exception was detected but the transaction is failed in".concat(className));
    }

}
