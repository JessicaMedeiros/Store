package io.github.jessicamedeiros.store.resources;


import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.service.CategoryService;
import io.github.jessicamedeiros.store.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/clients")
@RestController
public class ClientResource {

    @Autowired
    private ClientService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Client> find(@PathVariable Integer id){
        Client obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
