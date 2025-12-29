package com.example.inventory_service_query.handlers;

import com.example.inventory_service_query.entities.Category;
import com.example.inventory_service_query.entities.Product;
import com.example.inventory_service_query.events.*;
import com.example.inventory_service_query.repositories.CategoryRepository;
import com.example.inventory_service_query.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryEventHandler {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // ==================== PRODUCT EVENT HANDLERS ====================

    @EventHandler
    public void on(ProductCreatedEvent event) {
        log.info("================> ProductCreatedEvent received: {}", event.getId());

        Product product = Product.builder()
                .id(event.getId())
                .name(event.getName())
                .price(event.getPrice())
                .quantity(event.getQuantity())
                .state(event.getState())
                .categoryId(event.getCategoryId())
                .build();

        productRepository.save(product);
        log.info("Product saved in query database: {}", product.getId());
    }

    @EventHandler
    public void on(ProductQuantityUpdatedEvent event) {
        log.info("================> ProductQuantityUpdatedEvent received: {}", event.getId());

        productRepository.findById(event.getId()).ifPresent(product -> {
            product.setQuantity(event.getQuantity());
            productRepository.save(product);
            log.info("Product quantity updated: {}", product.getId());
        });
    }

    @EventHandler
    public void on(ProductStateChangedEvent event) {
        log.info("================> ProductStateChangedEvent received: {}", event.getId());

        productRepository.findById(event.getId()).ifPresent(product -> {
            product.setState(event.getState());
            productRepository.save(product);
            log.info("Product state updated: {}", product.getId());
        });
    }

    @EventHandler
    public void on(ProductPriceUpdatedEvent event) {
        log.info("================> ProductPriceUpdatedEvent received: {}", event.getId());

        productRepository.findById(event.getId()).ifPresent(product -> {
            product.setPrice(event.getPrice());
            productRepository.save(product);
            log.info("Product price updated: {}", product.getId());
        });
    }

    @EventHandler
    public void on(ProductUpdatedEvent event) {
        log.info("================> ProductUpdatedEvent received: {}", event.getId());

        productRepository.findById(event.getId()).ifPresent(product -> {
            product.setName(event.getName());
            product.setPrice(event.getPrice());
            product.setQuantity(event.getQuantity());
            product.setState(event.getState());
            product.setCategoryId(event.getCategoryId());
            productRepository.save(product);
            log.info("Product fully updated: {}", product.getId());
        });
    }

    @EventHandler
    public void on(ProductDeletedEvent event) {
        log.info("================> ProductDeletedEvent received: {}", event.getId());

        productRepository.deleteById(event.getId());
        log.info("Product deleted from query database: {}", event.getId());
    }

    // ==================== CATEGORY EVENT HANDLERS ====================

    @EventHandler
    public void on(CategoryCreatedEvent event) {
        log.info("================> CategoryCreatedEvent received: {}", event.getId());

        Category category = Category.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .build();

        categoryRepository.save(category);
        log.info("Category saved in query database: {}", category.getId());
    }

    @EventHandler
    public void on(CategoryUpdatedEvent event) {
        log.info("================> CategoryUpdatedEvent received: {}", event.getId());

        categoryRepository.findById(event.getId()).ifPresent(category -> {
            category.setName(event.getName());
            category.setDescription(event.getDescription());
            categoryRepository.save(category);
            log.info("Category updated: {}", category.getId());
        });
    }

    @EventHandler
    public void on(CategoryDeletedEvent event) {
        log.info("================> CategoryDeletedEvent received: {}", event.getId());

        categoryRepository.deleteById(event.getId());
        log.info("Category deleted from query database: {}", event.getId());
    }
}
