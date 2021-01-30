package io.github.jessicamedeiros.store.resources;


import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.payment.Order;
import io.github.jessicamedeiros.store.service.CategoryService;
import io.github.jessicamedeiros.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
