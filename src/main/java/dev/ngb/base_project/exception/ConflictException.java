package dev.ngb.base_project.exception;

public class ConflictException extends ClientErrorException {

    public ConflictException(String message) {
        super(message);
    }
}
