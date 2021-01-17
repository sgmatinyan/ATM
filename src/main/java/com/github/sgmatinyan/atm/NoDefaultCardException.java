package com.github.sgmatinyan.atm;

public class NoDefaultCardException extends Exception{
    public NoDefaultCardException() {
    }

    public NoDefaultCardException(String message) {
        super(message);
    }

    public NoDefaultCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDefaultCardException(Throwable cause) {
        super(cause);
    }

    public NoDefaultCardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
