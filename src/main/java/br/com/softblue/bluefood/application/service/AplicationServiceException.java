package br.com.softblue.bluefood.application.service;

public class AplicationServiceException extends  RuntimeException {
    public AplicationServiceException() {
    }

    public AplicationServiceException(String message) {
        super(message);
    }

    public AplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AplicationServiceException(Throwable cause) {
        super(cause);
    }

    public AplicationServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
