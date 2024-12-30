package br.com.desafio.api_cursos.exceptions;
@SuppressWarnings("serial")
public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg){
        super(msg);
    }
}
