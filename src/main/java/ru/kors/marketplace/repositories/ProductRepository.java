package ru.kors.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.marketplace.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
