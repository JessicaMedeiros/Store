package io.github.jessicamedeiros.store.repository;

import io.github.jessicamedeiros.store.model.Product;
import io.github.jessicamedeiros.store.model.payment.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
