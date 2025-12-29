package com.example.inventory_comman_api.events;
import lombok.Getter;
@Getter
public class CategoryDeletedEvent extends BaseEvent<String> {
    public CategoryDeletedEvent(String id) {
        super(id);
    }
}
