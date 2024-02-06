package dev.ngb.base_project.exception;

public class NotFoundException extends ClientErrorException {

    public NotFoundException(String message) {
        super(message);
    }
}
