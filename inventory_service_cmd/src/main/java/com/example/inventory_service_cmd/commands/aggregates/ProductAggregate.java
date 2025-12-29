package com.example.inventory_service_cmd.commands.aggregates;

import com.example.inventory_service_cmd.commands.commands.*;
import com.example.inventory_service_cmd.enums.ProductState;
import com.example.inventory_service_cmd.events.*;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private ProductState state;
    private String categoryId;

    // ==================== COMMAND HANDLERS ====================

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        System.out.println("================> CreateProductCommand received");

        // Business validation
        if (command.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (command.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        // Publish event
        AggregateLifecycle.apply(new ProductCreatedEvent(
                command.getId(),
                command.getName(),
                command.getPrice(),
                command.getQuantity(),
                command.getState(),
                command.getCategoryId()
        ));
    }

    @CommandHandler
    public void handle(UpdateProductQuantityCommand command) {
        System.out.println("================> UpdateProductQuantityCommand received");

        if (command.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        AggregateLifecycle.apply(new ProductQuantityUpdatedEvent(
                command.getId(),
                command.getQuantity()
        ));
    }

    @CommandHandler
    public void handle(UpdateProductStateCommand command) {
        System.out.println("================> UpdateProductStateCommand received");

        AggregateLifecycle.apply(new ProductStateChangedEvent(
                command.getId(),
                command.getState()
        ));
    }

    @CommandHandler
    public void handle(UpdateProductPriceCommand command) {
        System.out.println("================> UpdateProductPriceCommand received");

        if (command.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        AggregateLifecycle.apply(new ProductPriceUpdatedEvent(
                command.getId(),
                command.getPrice()
        ));
    }

    @CommandHandler
    public void handle(UpdateProductCommand command) {
        System.out.println("================> UpdateProductCommand received");

        if (command.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (command.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        AggregateLifecycle.apply(new ProductUpdatedEvent(
                command.getId(),
                command.getName(),
                command.getPrice(),
                command.getQuantity(),
                command.getState(),
                command.getCategoryId()
        ));
    }

    @CommandHandler
    public void handle(DeleteProductCommand command) {
        System.out.println("================> DeleteProductCommand received");

        AggregateLifecycle.apply(new ProductDeletedEvent(
                command.getId()
        ));
    }

    // ==================== EVENT SOURCING HANDLERS ====================

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        System.out.println("================> ProductCreatedEvent handled");
        this.productId = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
        this.state = event.getState();
        this.categoryId = event.getCategoryId();
    }

    @EventSourcingHandler
    public void on(ProductQuantityUpdatedEvent event) {
        System.out.println("================> ProductQuantityUpdatedEvent handled");
        this.quantity = event.getQuantity();
    }

    @EventSourcingHandler
    public void on(ProductStateChangedEvent event) {
        System.out.println("================> ProductStateChangedEvent handled");
        this.state = event.getState();
    }

    @EventSourcingHandler
    public void on(ProductPriceUpdatedEvent event) {
        System.out.println("================> ProductPriceUpdatedEvent handled");
        this.price = event.getPrice();
    }

    @EventSourcingHandler
    public void on(ProductUpdatedEvent event) {
        System.out.println("================> ProductUpdatedEvent handled");
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
        this.state = event.getState();
        this.categoryId = event.getCategoryId();
    }

    @EventSourcingHandler
    public void on(ProductDeletedEvent event) {
        System.out.println("================> ProductDeletedEvent handled");
        // Mark for deletion - Axon handles the rest
    }
}