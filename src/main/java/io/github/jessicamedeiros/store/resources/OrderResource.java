package io.github.jessicamedeiros.store.resources;


import io.github.jessicamedeiros.store.dto.CategoryDTO;
import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.payment.Order;
import io.github.jessicamedeiros.store.service.CategoryService;
import io.github.jessicamedeiros.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping(value="/orders")
@RestController
public class OrderResource {

    @Autowired
    private OrderService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Order> find(@PathVariable Integer id){
        Order obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    //Como order tem muitos dados associados (lineitem, payment), se fosse usado o DTO seria um enorme ou vários
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody @Valid Order order){
        order = service.create(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
