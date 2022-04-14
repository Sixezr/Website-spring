package ru.sixzr.exceptions;

public class NotUniquePhoneException extends RuntimeException {
    public NotUniquePhoneException() {
    }

    public NotUniquePhoneException(String message) {
        super(message);
    }

    public NotUniquePhoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUniquePhoneException(Throwable cause) {
        super(cause);
    }

    public NotUniquePhoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
