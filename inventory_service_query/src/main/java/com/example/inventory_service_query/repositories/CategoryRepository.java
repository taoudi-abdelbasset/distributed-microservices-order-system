package com.example.inventory_service_query.repositories;

import com.example.inventory_service_query.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    // Find category by name
    Category findByName(String name);

    // Find categories by name containing (optional)
    List<Category> findByNameContainingIgnoreCase(String name);
}