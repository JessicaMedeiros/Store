package io.github.jessicamedeiros.store.dto;

import io.github.jessicamedeiros.store.model.Category;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String name;

    public CategoryDTO(){

    }

    public CategoryDTO(Category obj){
        id = obj.getId();
        name = obj.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
