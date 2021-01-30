package io.github.jessicamedeiros.store.service.exceptions;

public class DataIntegrityException extends RuntimeException{

    private static final long seriaVersionUID = 1l;

    public DataIntegrityException(String msg){
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause){
        super(msg, cause);
    }
}
