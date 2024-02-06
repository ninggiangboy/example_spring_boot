package dev.ngb.base_project.exception;

public class ClientErrorException extends RuntimeException {

    public ClientErrorException(String message) {
        super(message);
    }
}
