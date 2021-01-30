package io.github.jessicamedeiros.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jessicamedeiros.store.model.payment.Order;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class LineItem implements Serializable {
    private static final long serialVersionUID = 1l;


    @JsonIgnore
    @EmbeddedId
    private LineItemPK id = new LineItemPK();

    private Double discount;
    private Integer quantidade;
    private Double preco;


    public LineItem(){

    }

    //Nao faz sentido colcoar o lineitempk no construtor. Visto que o que a gente quer com ele é associar
    //product e order no lineitem
    public LineItem(Order order, Product product, Double discount, Integer quantidade, Double preco) {
        this.id = id;
        id.setOrder(order);
        id.setProduct(product);
        this.discount = discount;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public Product getProduct(){
        return id.getProduct();
    }


    public LineItemPK getId() {
        return id;
    }

    public Double getDiscount() {
        return discount;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return id.equals(lineItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
