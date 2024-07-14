package com.bookmyshow.bookmyshow.exceptions;

public class InvalidCredentialException extends RuntimeException {

    public InvalidCredentialException(String credentialsAreInvalid) {
        super(credentialsAreInvalid);
    }
}
