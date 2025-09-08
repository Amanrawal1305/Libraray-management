package com.aman.digitalLibrary.exception;

public class BookAlreadyPresent extends RuntimeException {
    public BookAlreadyPresent(String message) {
        super(message);
    }
}
