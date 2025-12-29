package com.example.inventory_comman_api.events;
import com.example.inventory_comman_api.enums.ProductState;
import lombok.Getter;
@Getter
public class ProductDeletedEvent extends BaseEvent<String> {
    public ProductDeletedEvent(String id) {
        super(id);
    }
}
