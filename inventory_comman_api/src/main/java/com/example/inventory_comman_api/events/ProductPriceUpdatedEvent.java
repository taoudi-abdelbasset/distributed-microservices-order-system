package com.example.inventory_comman_api.events;
import com.example.inventory_comman_api.enums.ProductState;
import lombok.Getter;
@Getter
public class ProductPriceUpdatedEvent extends BaseEvent<String> {
    private double price;

    public ProductPriceUpdatedEvent(String id, double price) {
        super(id);
        this.price = price;
    }
}
