package br.com.desafio.api_cursos.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
