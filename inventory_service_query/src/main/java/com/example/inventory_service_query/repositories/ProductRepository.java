package com.example.inventory_service_query.repositories;

import com.example.inventory_service_query.entities.Product;
import com.example.inventory_service_query.enums.ProductState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // Find products by category
    List<Product> findByCategoryId(String categoryId);

    // Find products by state
    List<Product> findByState(ProductState state);

    // Find products by name (optional)
    List<Product> findByNameContainingIgnoreCase(String name);

    // Find products with price range (optional)
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}

