package io.github.jessicamedeiros.store.repository;

import io.github.jessicamedeiros.store.model.Address;
import io.github.jessicamedeiros.store.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Integer> {
}
