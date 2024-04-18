package com.example.AIBooks.errorException;

public class BadRequestException  extends RuntimeException  {
    public BadRequestException(String message) {
        super(message);
    }
}
