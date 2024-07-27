package com.bookmyshow.bookmyshow.exceptions;

public class MovieNotFoundException extends  RuntimeException {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
