package br.com.veterinaryclinic.dtos;

public record RegisterRequest(String login, String password, String role) {
}
