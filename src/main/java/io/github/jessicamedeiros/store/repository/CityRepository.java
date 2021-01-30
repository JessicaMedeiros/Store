package io.github.jessicamedeiros.store.repository;

import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
