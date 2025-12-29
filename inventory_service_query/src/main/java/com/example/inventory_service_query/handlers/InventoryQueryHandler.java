package com.example.inventory_service_query.handlers;

import com.example.inventory_service_query.entities.Category;
import com.example.inventory_service_query.entities.Product;
import com.example.inventory_service_query.enums.ProductState;
import com.example.inventory_service_query.queries.*;
import com.example.inventory_service_query.repositories.CategoryRepository;
import com.example.inventory_service_query.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryQueryHandler {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // ==================== PRODUCT QUERY HANDLERS ====================

    @QueryHandler
    public List<Product> handle(GetAllProductsQuery query) {
        log.info("================> GetAllProductsQuery handled");
        return productRepository.findAll();
    }

    @QueryHandler
    public Product handle(GetProductByIdQuery query) {
        log.info("================> GetProductByIdQuery handled: {}", query.getProductId());
        return productRepository.findById(query.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found: " + query.getProductId()));
    }

    @QueryHandler
    public List<Product> handle(GetProductsByCategoryQuery query) {
        log.info("================> GetProductsByCategoryQuery handled: {}", query.getCategoryId());
        return productRepository.findByCategoryId(query.getCategoryId());
    }

    @QueryHandler
    public List<Product> handle(GetProductsByStateQuery query) {
        log.info("================> GetProductsByStateQuery handled: {}", query.getState());
        ProductState state = ProductState.valueOf(query.getState().toUpperCase());
        return productRepository.findByState(state);
    }

    // ==================== CATEGORY QUERY HANDLERS ====================

    @QueryHandler
    public List<Category> handle(GetAllCategoriesQuery query) {
        log.info("================> GetAllCategoriesQuery handled");
        return categoryRepository.findAll();
    }

    @QueryHandler
    public Category handle(GetCategoryByIdQuery query) {
        log.info("================> GetCategoryByIdQuery handled: {}", query.getCategoryId());
        return categoryRepository.findById(query.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found: " + query.getCategoryId()));
    }
}