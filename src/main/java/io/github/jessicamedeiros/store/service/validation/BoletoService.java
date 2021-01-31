package io.github.jessicamedeiros.store.service.validation;

import io.github.jessicamedeiros.store.model.payment.PaymentByBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void fillOutPaymentByBoleto(PaymentByBoleto pay, Date instante){
        Calendar cal = Calendar.getInstance();
        cal.setTime(instante);;
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pay.setPaymentDate(cal.getTime());
    }
}
