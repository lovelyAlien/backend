package com.sparta.backend.repository;

import com.sparta.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByModifiedAtDesc();
    List<Product> findByNameContaining(String keyword);
}
