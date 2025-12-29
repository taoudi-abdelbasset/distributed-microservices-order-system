package com.example.inventory_service_query.events;
import com.example.inventory_service_query.enums.ProductState;
import lombok.Getter;
@Getter
public class ProductPriceUpdatedEvent extends BaseEvent<String> {
    private double price;

    public ProductPriceUpdatedEvent(String id, double price) {
        super(id);
        this.price = price;
    }
}
