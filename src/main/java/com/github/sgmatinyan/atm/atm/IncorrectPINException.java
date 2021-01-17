package com.github.sgmatinyan.atm.atm;

public class IncorrectPINException extends Exception{
    public IncorrectPINException() {
    }

    public IncorrectPINException(String message) {
        super(message);
    }

    public IncorrectPINException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPINException(Throwable cause) {
        super(cause);
    }

    public IncorrectPINException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
