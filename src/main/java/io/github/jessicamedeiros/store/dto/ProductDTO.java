package io.github.jessicamedeiros.store.dto;

import io.github.jessicamedeiros.store.model.Product;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;
    private String name;
    private Double price;

    public ProductDTO(){

    }

    public ProductDTO(Product obj) {
        id = obj.getId();
        name = obj.getName();
        price = obj.getPrice();
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
