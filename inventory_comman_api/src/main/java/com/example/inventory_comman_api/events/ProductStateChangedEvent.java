package com.example.inventory_comman_api.events;
import com.example.inventory_comman_api.enums.ProductState;
import lombok.Getter;

@Getter
public class ProductStateChangedEvent extends BaseEvent<String> {
    private ProductState state;

    public ProductStateChangedEvent(String id, ProductState state) {
        super(id);
        this.state = state;
    }
}
