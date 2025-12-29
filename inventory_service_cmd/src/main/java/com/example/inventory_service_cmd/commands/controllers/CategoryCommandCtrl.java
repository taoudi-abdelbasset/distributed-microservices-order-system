package com.example.inventory_service_cmd.commands.controllers;

import com.example.inventory_service_cmd.commands.commands.CreateCategoryCommand;
import com.example.inventory_service_cmd.commands.commands.DeleteCategoryCommand;
import com.example.inventory_service_cmd.commands.commands.UpdateCategoryCommand;
import com.example.inventory_service_cmd.commands.dtos.CreateCategoryRequestDTO;
import com.example.inventory_service_cmd.commands.dtos.UpdateCategoryRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commands/categories")
@AllArgsConstructor
public class CategoryCommandCtrl {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createCategory(@RequestBody CreateCategoryRequestDTO request) {
        System.out.println("================> Creating Category");
        CompletableFuture<String> result = commandGateway.send(new CreateCategoryCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getDescription()
        ));
        return result;
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateCategory(@RequestBody UpdateCategoryRequestDTO request) {
        System.out.println("================> Updating Category");
        CompletableFuture<String> result = commandGateway.send(new UpdateCategoryCommand(
                request.getCategoryId(),
                request.getName(),
                request.getDescription()
        ));
        return result;
    }

    @DeleteMapping("/delete/{categoryId}")
    public CompletableFuture<String> deleteCategory(@PathVariable String categoryId) {
        System.out.println("================> Deleting Category");
        CompletableFuture<String> result = commandGateway.send(new DeleteCategoryCommand(categoryId));
        return result;
    }

    @GetMapping("/eventStore/{categoryId}")
    public Stream eventStore(@PathVariable String categoryId) {
        return eventStore.readEvents(categoryId).asStream();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }
}
