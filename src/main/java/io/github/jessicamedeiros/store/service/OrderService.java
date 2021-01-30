package io.github.jessicamedeiros.store.service;

import io.github.jessicamedeiros.store.model.payment.Order;
import io.github.jessicamedeiros.store.model.payment.Payment;
import io.github.jessicamedeiros.store.repository.OrderRepository;
import io.github.jessicamedeiros.store.repository.PaymentRepository;
import io.github.jessicamedeiros.store.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order find(Integer id){
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Client não encontrado! Id: " + id + ", Tipo: " + Order.class.getName()));

    }
}
