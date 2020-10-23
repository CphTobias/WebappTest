package com.tobias.function.exceptions;

public class ValidationError extends Exception {
    public ValidationError(String message) {
        super(message);
    }
}
