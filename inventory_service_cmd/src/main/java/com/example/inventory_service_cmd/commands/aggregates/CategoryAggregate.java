package com.example.inventory_service_cmd.commands.aggregates;

import com.example.inventory_service_cmd.commands.commands.CreateCategoryCommand;
import com.example.inventory_service_cmd.commands.commands.DeleteCategoryCommand;
import com.example.inventory_service_cmd.commands.commands.UpdateCategoryCommand;
import com.example.inventory_service_cmd.events.CategoryCreatedEvent;
import com.example.inventory_service_cmd.events.CategoryDeletedEvent;
import com.example.inventory_service_cmd.events.CategoryUpdatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class CategoryAggregate {

    @AggregateIdentifier
    private String categoryId;
    private String name;
    private String description;

    // ==================== COMMAND HANDLERS ====================

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command) {
        System.out.println("================> CreateCategoryCommand received");

        // Business validation
        if (command.getName() == null || command.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }

        // Publish event
        AggregateLifecycle.apply(new CategoryCreatedEvent(
                command.getId(),
                command.getName(),
                command.getDescription()
        ));
    }

    @CommandHandler
    public void handle(UpdateCategoryCommand command) {
        System.out.println("================> UpdateCategoryCommand received");

        if (command.getName() == null || command.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }

        AggregateLifecycle.apply(new CategoryUpdatedEvent(
                command.getId(),
                command.getName(),
                command.getDescription()
        ));
    }

    @CommandHandler
    public void handle(DeleteCategoryCommand command) {
        System.out.println("================> DeleteCategoryCommand received");

        AggregateLifecycle.apply(new CategoryDeletedEvent(
                command.getId()
        ));
    }

    // ==================== EVENT SOURCING HANDLERS ====================

    @EventSourcingHandler
    public void on(CategoryCreatedEvent event) {
        System.out.println("================> CategoryCreatedEvent handled");
        this.categoryId = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
    }

    @EventSourcingHandler
    public void on(CategoryUpdatedEvent event) {
        System.out.println("================> CategoryUpdatedEvent handled");
        this.name = event.getName();
        this.description = event.getDescription();
    }

    @EventSourcingHandler
    public void on(CategoryDeletedEvent event) {
        System.out.println("================> CategoryDeletedEvent handled");
        // Mark for deletion - Axon handles the rest
    }
}
