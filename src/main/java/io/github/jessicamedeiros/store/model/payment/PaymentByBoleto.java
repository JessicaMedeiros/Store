package io.github.jessicamedeiros.store.model.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.jessicamedeiros.store.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentByBoleto extends Payment {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    public Date paymentDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    public Date expirationDate;

    public PaymentByBoleto(){

    }

    public PaymentByBoleto(Integer id, PaymentStatus status, Order order, Date expirationDate, Date paymentDate
                           ) {
        super(id, status, order);
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}


