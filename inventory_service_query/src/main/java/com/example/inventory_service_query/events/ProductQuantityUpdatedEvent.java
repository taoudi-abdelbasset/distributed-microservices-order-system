package com.example.inventory_service_query.events;
import com.example.inventory_service_query.enums.ProductState;
import lombok.Getter;
@Getter
public class ProductQuantityUpdatedEvent extends BaseEvent<String> {
    private int quantity;

    public ProductQuantityUpdatedEvent(String id, int quantity) {
        super(id);
        this.quantity = quantity;
    }
}
