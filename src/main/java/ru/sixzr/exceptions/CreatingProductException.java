package ru.sixzr.exceptions;

public class CreatingProductException extends RuntimeException {
    public CreatingProductException() {
    }

    public CreatingProductException(String message) {
        super(message);
    }

    public CreatingProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatingProductException(Throwable cause) {
        super(cause);
    }

    public CreatingProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
