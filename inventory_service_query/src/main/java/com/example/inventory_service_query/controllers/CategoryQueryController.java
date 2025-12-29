package com.example.inventory_service_query.controllers;

import com.example.inventory_service_query.entities.Category;
import com.example.inventory_service_query.queries.GetAllCategoriesQuery;
import com.example.inventory_service_query.queries.GetCategoryByIdQuery;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/query/categories")
@AllArgsConstructor
public class CategoryQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Category>> getAllCategories() {
        return queryGateway.query(
                new GetAllCategoriesQuery(),
                ResponseTypes.multipleInstancesOf(Category.class)
        );
    }

    @GetMapping("/{categoryId}")
    public CompletableFuture<Category> getCategoryById(@PathVariable String categoryId) {
        return queryGateway.query(
                new GetCategoryByIdQuery(categoryId),
                ResponseTypes.instanceOf(Category.class)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }
}
