package ru.sixzr.exceptions;

public class NotUniqueEmailException extends RuntimeException {
    public NotUniqueEmailException() {
    }

    public NotUniqueEmailException(String message) {
        super(message);
    }

    public NotUniqueEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUniqueEmailException(Throwable cause) {
        super(cause);
    }

    public NotUniqueEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
