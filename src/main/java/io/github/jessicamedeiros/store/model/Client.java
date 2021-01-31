package io.github.jessicamedeiros.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.jessicamedeiros.store.enums.ClientType;
import io.github.jessicamedeiros.store.model.payment.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;
    private String email;
    private String cpfORcnpj;
    private Integer type;


    //Toda a operação de Client vai ser sentida por Address
    @OneToMany(mappedBy = "client", cascade=CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telephone")
    private Set<String> telephone = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Client(){

    }

    public Client(Integer id, String name, String email, String cpfORcnpj, ClientType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfORcnpj = cpfORcnpj;
        this.type = (type==null) ? null : type.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfORcnpj() {
        return cpfORcnpj;
    }

    public void setCpfORcnpj(String cpfORcnpj) {
        this.cpfORcnpj = cpfORcnpj;
    }

    public ClientType getType() {
        return ClientType.toEnum(type);
    }

    public void setType(ClientType type) {
        this.type = type.getCod();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getTelephone() {
        return telephone;
    }

    public void setTelephone(Set<String> telephone) {
        this.telephone = telephone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
