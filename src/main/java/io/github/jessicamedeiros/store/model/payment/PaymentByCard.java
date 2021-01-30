package io.github.jessicamedeiros.store.model.payment;

import io.github.jessicamedeiros.store.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentByCard extends Payment {
    private static final long serialVersionUID = 1L;

    public Integer installmentsCredit;

    public PaymentByCard(){

    }

    public PaymentByCard(Integer id, PaymentStatus status, Order order, Integer installmentsCredit) {
        super(id, status, order);
        this.installmentsCredit = installmentsCredit;
    }

    public Integer getInstallmentsCredit() {
        return installmentsCredit;
    }

    public void setInstallmentsCredit(Integer installmentsCredit) {
        this.installmentsCredit = installmentsCredit;
    }


}
