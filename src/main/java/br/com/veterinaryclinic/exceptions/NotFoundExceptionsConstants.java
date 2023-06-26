package br.com.veterinaryclinic.exceptions;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NotFoundExceptionsConstants {
    public static final String CLIENT_NOT_FOUND = "Client with id [%d] not found!";
    public static final String Pet_NOT_FOUND = "Pet with id [%d] not found!";
}