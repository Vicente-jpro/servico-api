package com.example.loja2023.exceptions;

public class UsuarioCadastradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsuarioCadastradoException(String email) {
        super("Usuário com email " + email + " já está cadastrado");
    }
}
