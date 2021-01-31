package io.github.jessicamedeiros.store.repository;

import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Transactional
    Client findByEmail(String email);
}
