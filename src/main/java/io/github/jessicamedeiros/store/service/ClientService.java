package io.github.jessicamedeiros.store.service;

import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.repository.CategoryRepository;
import io.github.jessicamedeiros.store.repository.ClientRepository;
import io.github.jessicamedeiros.store.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;


    public Client find(Integer id){
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Client não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
    }

}
