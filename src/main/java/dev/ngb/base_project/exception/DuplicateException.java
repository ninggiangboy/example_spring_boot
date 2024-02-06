package dev.ngb.base_project.exception;

public class DuplicateException extends ClientErrorException {

    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException() {
        super("Duplicate exception");
    }
}
