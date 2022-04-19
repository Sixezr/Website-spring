package ru.sixzr.exceptions;

public class NotFoundProductException extends RuntimeException {
    public NotFoundProductException() {
    }

    public NotFoundProductException(String message) {
        super(message);
    }

    public NotFoundProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundProductException(Throwable cause) {
        super(cause);
    }

    public NotFoundProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
