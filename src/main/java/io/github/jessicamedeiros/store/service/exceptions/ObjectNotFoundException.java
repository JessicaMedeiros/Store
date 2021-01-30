package io.github.jessicamedeiros.store.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    private static final long seriaVersionUID = 1l;

    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
