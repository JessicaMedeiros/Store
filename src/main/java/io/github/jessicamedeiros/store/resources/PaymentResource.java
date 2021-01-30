package io.github.jessicamedeiros.store.resources;

import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.model.payment.Payment;
import io.github.jessicamedeiros.store.service.ClientService;
import io.github.jessicamedeiros.store.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Payment> find(@PathVariable Integer id){
        Payment obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
