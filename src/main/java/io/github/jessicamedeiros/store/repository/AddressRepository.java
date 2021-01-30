package io.github.jessicamedeiros.store.repository;

import io.github.jessicamedeiros.store.model.Address;
import io.github.jessicamedeiros.store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
