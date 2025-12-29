package com.example.inventory_service_query.events;
import com.example.inventory_service_query.enums.ProductState;
import lombok.Getter;

@Getter
public class ProductStateChangedEvent extends BaseEvent<String> {
    private ProductState state;

    public ProductStateChangedEvent(String id, ProductState state) {
        super(id);
        this.state = state;
    }
}
