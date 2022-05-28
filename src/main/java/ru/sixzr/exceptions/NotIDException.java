package ru.sixzr.exceptions;

public class NotIDException extends RuntimeException {
    public NotIDException() {
    }

    public NotIDException(String message) {
        super(message);
    }

    public NotIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotIDException(Throwable cause) {
        super(cause);
    }

    public NotIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
