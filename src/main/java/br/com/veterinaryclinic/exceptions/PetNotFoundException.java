package br.com.veterinaryclinic.exceptions;

public class PetNotFoundException extends NotFoundException {
    public PetNotFoundException(Long id) {
        super(NotFoundExceptionsConstants.Pet_NOT_FOUND, id);
    }
}
