package br.com.veterinaryclinic.dtos;

import br.com.veterinaryclinic.enums.Role;

public record RegisterRequest(String name,
                              String emailAddress,
                              String username,
                              String password,
                              Role role,
                              Long badgeNumber) {
}