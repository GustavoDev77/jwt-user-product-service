package com.projetospringvalidation.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
