package com.example.inventory_service_cmd.events;
import lombok.Getter;
@Getter
public class CategoryUpdatedEvent extends BaseEvent<String> {
    private String name;
    private String description;

    public CategoryUpdatedEvent(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
