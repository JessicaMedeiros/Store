package io.github.jessicamedeiros.store.service.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1l;

    private String fieldName;
    private String message;

    private FieldMessage(){

    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
