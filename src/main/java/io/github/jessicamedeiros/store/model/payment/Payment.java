package io.github.jessicamedeiros.store.model.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.jessicamedeiros.store.enums.PaymentStatus;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1l;


  //  @GeneratedValue(strategy = GenerationType.IDENTITY) - nao sera usado pois o id do payment tem que ser o mesmo do order
    @Id
    private Integer id;

    private Integer status;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="order_id")
    @MapsId
    private Order order;


    public Payment(){

    }

    public Payment(Integer id, PaymentStatus status, Order order) {
        super();
        this.id = id;
        this.status  = (status==null) ? null : status.getCod();
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {

        return PaymentStatus.toEnum(status);
    }

    public void setStatus(PaymentStatus status) {

        this.status = status.getCod();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
