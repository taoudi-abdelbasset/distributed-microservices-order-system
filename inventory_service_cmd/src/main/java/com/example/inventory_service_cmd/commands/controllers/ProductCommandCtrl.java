package com.example.inventory_service_cmd.commands.controllers;

import com.example.inventory_service_cmd.commands.commands.*;
import com.example.inventory_service_cmd.commands.dtos.*;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commands/products")
@AllArgsConstructor
public class ProductCommandCtrl {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createProduct(@RequestBody CreateProductRequestDTO request) {
        System.out.println("================> Creating Product");
        CompletableFuture<String> result = commandGateway.send(new CreateProductCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getState(),
                request.getCategoryId()
        ));
        return result;
    }

    @PutMapping("/update-quantity")
    public CompletableFuture<String> updateProductQuantity(@RequestBody UpdateProductQuantityRequestDTO request) {
        System.out.println("================> Updating Product Quantity");
        CompletableFuture<String> result = commandGateway.send(new UpdateProductQuantityCommand(
                request.getProductId(),
                request.getQuantity()
        ));
        return result;
    }

    @PutMapping("/update-state")
    public CompletableFuture<String> updateProductState(@RequestBody UpdateProductStateRequestDTO request) {
        System.out.println("================> Updating Product State");
        CompletableFuture<String> result = commandGateway.send(new UpdateProductStateCommand(
                request.getProductId(),
                request.getState()
        ));
        return result;
    }

    @PutMapping("/update-price")
    public CompletableFuture<String> updateProductPrice(@RequestBody UpdateProductPriceRequestDTO request) {
        System.out.println("================> Updating Product Price");
        CompletableFuture<String> result = commandGateway.send(new UpdateProductPriceCommand(
                request.getProductId(),
                request.getPrice()
        ));
        return result;
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateProduct(@RequestBody UpdateProductRequestDTO request) {
        System.out.println("================> Updating Full Product");
        CompletableFuture<String> result = commandGateway.send(new UpdateProductCommand(
                request.getProductId(),
                request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getState(),
                request.getCategoryId()
        ));
        return result;
    }

    @DeleteMapping("/delete/{productId}")
    public CompletableFuture<String> deleteProduct(@PathVariable String productId) {
        System.out.println("================> Deleting Product");
        CompletableFuture<String> result = commandGateway.send(new DeleteProductCommand(productId));
        return result;
    }

    @GetMapping("/eventStore/{productId}")
    public Stream eventStore(@PathVariable String productId) {
        return eventStore.readEvents(productId).asStream();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }
}
