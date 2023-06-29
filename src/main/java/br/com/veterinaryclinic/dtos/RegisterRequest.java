package br.com.veterinaryclinic.dtos;

import br.com.veterinaryclinic.enums.Role;

public record RegisterRequest(String login, String password, Role role) {
}
