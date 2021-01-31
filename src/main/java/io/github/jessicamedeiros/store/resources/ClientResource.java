package io.github.jessicamedeiros.store.resources;


import io.github.jessicamedeiros.store.dto.*;
import io.github.jessicamedeiros.store.dto.ClientDTO;
import io.github.jessicamedeiros.store.dto.ClientDTO;
import io.github.jessicamedeiros.store.dto.ClientDTO;
import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.service.ClientService;
import io.github.jessicamedeiros.store.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody @Valid NewClientDTO objDTO){
        Client obj = service.fromNewDTO(objDTO);
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody @Valid ClientDTO updatedObj){
        Client obj = service.fromDTO(updatedObj);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<Client> list = service.findAll();
        //vai percorrer a lista e fazer uma operacao para cada elemento da lista
        List<ClientDTO> listDTO =  list.stream().map(obj ->
                new ClientDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    
    @RequestMapping(value = "/page", method=RequestMethod.GET)
    public ResponseEntity<Page<ClientDTO>> findPage(@RequestParam (value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam (value = "linesPerPage", defaultValue = "24") Integer linesPerPage, //24 é mais responsivo
                                                      @RequestParam (value = "orderBy", defaultValue = "name") String orderBy,
                                                      @RequestParam (value = "direction", defaultValue = "ASC") String direction){

        Page<Client> list = service.findPage(page, linesPerPage, orderBy, direction);
        //vai percorrer a lista e fazer uma operacao para cada elemento da lista
        Page<ClientDTO> listDTO =  list.map(obj ->
                new ClientDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }


}
