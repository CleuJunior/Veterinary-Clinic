package br.com.veterinaryclinic.exceptions;

public class ClientNotFoundException extends NotFoundException {
    public ClientNotFoundException(Long id) {
        super(NotFoundExceptionsConstants.CLIENT_NOT_FOUND, id);
    }
}
