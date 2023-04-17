package com.grechishkin.sales.repositories;

import com.grechishkin.sales.entities.Price;
import com.grechishkin.sales.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
}