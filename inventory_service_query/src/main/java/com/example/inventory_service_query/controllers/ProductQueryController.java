package com.example.inventory_service_query.controllers;

import com.example.inventory_service_query.entities.Product;
import com.example.inventory_service_query.queries.*;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/query/products")
@AllArgsConstructor
public class ProductQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Product>> getAllProducts() {
        return queryGateway.query(
                new GetAllProductsQuery(),
                ResponseTypes.multipleInstancesOf(Product.class)
        );
    }

    @GetMapping("/{productId}")
    public CompletableFuture<Product> getProductById(@PathVariable String productId) {
        return queryGateway.query(
                new GetProductByIdQuery(productId),
                ResponseTypes.instanceOf(Product.class)
        );
    }

    @GetMapping("/category/{categoryId}")
    public CompletableFuture<List<Product>> getProductsByCategory(@PathVariable String categoryId) {
        return queryGateway.query(
                new GetProductsByCategoryQuery(categoryId),
                ResponseTypes.multipleInstancesOf(Product.class)
        );
    }

    @GetMapping("/state/{state}")
    public CompletableFuture<List<Product>> getProductsByState(@PathVariable String state) {
        return queryGateway.query(
                new GetProductsByStateQuery(state),
                ResponseTypes.multipleInstancesOf(Product.class)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }
}