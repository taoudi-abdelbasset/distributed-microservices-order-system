package com.example.inventory_service_cmd.events;
import lombok.Getter;
@Getter
public class CategoryDeletedEvent extends BaseEvent<String> {
    public CategoryDeletedEvent(String id) {
        super(id);
    }
}
