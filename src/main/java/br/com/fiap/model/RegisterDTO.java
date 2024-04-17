package br.com.fiap.model;

import br.com.fiap.model.enums.Role;

public record RegisterDTO(String login, String password, Role role) {

}
