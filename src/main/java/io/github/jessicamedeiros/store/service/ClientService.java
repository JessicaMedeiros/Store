package io.github.jessicamedeiros.store.service;

import io.github.jessicamedeiros.store.dto.ClientDTO;
import io.github.jessicamedeiros.store.dto.ClientDTO;
import io.github.jessicamedeiros.store.dto.NewClientDTO;
import io.github.jessicamedeiros.store.enums.ClientType;
import io.github.jessicamedeiros.store.model.*;
import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.repository.AddressRepository;
import io.github.jessicamedeiros.store.repository.ClientRepository;
import io.github.jessicamedeiros.store.repository.ClientRepository;
import io.github.jessicamedeiros.store.service.exceptions.DataIntegrityException;
import io.github.jessicamedeiros.store.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private AddressRepository repoAddress;


    public Client find(Integer id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Client não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
    }

    @Transactional
    public Client create(Client obj) {
        obj.setId(null); //para garantir que será outra Category
        obj = repository.save(obj);
        repoAddress.saveAll(obj.getAddresses());
        return obj;
    }

    public Client update(Client obj) {
        Client newObj = find(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityException("Not possible to delete a nested Client");
        }
    }


    public List<Client> findAll() {
        return repository.findAll();
    }

    public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Client fromDTO(ClientDTO dto) {
        return new Client(dto.getId(), dto.getName(), dto.getEmail(), null, null);
    }

    public Client fromNewDTO(NewClientDTO dto) {
       Client client = new Client(null, dto.getName(), dto.getEmail(), dto.getCpfORcnpj(), ClientType.toEnum(dto.getType()));
       City city = new City(dto.getCityId(), null, null);
       Address address = new Address(null, dto.getStreet(), dto.getNumber(), dto.getComplement(), dto.getDistrict(), dto.getZipcode(), client, city);
       client.getAddresses().add(address);
       client.getTelephone().add(dto.getTelephone1());
       if(dto.getTelephone2() != null){
           client.getTelephone().add(dto.getTelephone2());}
       if(dto.getTelephone3() != null){
           client.getTelephone().add(dto.getTelephone3());}
       return client;
    }

    private void updateData(Client newObj, Client obj) {
        newObj.setName(obj.getName());
    }
}