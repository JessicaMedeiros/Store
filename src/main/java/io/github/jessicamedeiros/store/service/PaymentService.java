package io.github.jessicamedeiros.store.service;

import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.model.payment.Payment;
import io.github.jessicamedeiros.store.repository.PaymentRepository;
import io.github.jessicamedeiros.store.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment find(Integer id){
        Optional<Payment> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Client não encontrado! Id: " + id + ", Tipo: " + Payment.class.getName()));

    }
}
