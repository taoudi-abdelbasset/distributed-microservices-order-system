package com.example.inventory_comman_api.events;
import com.example.inventory_comman_api.enums.ProductState;
import lombok.Getter;
@Getter
public class ProductQuantityUpdatedEvent extends BaseEvent<String> {
    private int quantity;

    public ProductQuantityUpdatedEvent(String id, int quantity) {
        super(id);
        this.quantity = quantity;
    }
}
