package io.github.jessicamedeiros.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jessicamedeiros.store.model.payment.Order;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

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
    private Integer quantity;
    private Double price;


    public LineItem(){

    }

    //Nao faz sentido colcoar o lineitempk no construtor. Visto que o que a gente quer com ele é associar
    //product e order no lineitem
    public LineItem(Order order, Product product, Double discount, Integer quantity, Double price) {
        this.id = id;
        id.setOrder(order);
        id.setProduct(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }
    public double getSubTotal(){ //colocando o get na frente pra ser automaticamente serializado pelo Json
        return (price - discount) * quantity;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public LineItemPK getId() {
        return id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
