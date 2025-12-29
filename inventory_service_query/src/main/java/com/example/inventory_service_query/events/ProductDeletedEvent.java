package com.example.inventory_service_query.events;
import com.example.inventory_service_query.enums.ProductState;
import lombok.Getter;
@Getter
public class ProductDeletedEvent extends BaseEvent<String> {
    public ProductDeletedEvent(String id) {
        super(id);
    }
}
