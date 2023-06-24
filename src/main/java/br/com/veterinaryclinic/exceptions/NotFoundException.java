package br.com.veterinaryclinic.exceptions;

public abstract class NotFoundException extends RuntimeException {
    protected NotFoundException(String message, Long id) {
        super(String.format(message, id));
    }
}
