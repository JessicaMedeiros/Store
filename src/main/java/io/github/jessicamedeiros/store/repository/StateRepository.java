package io.github.jessicamedeiros.store.repository;

import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
