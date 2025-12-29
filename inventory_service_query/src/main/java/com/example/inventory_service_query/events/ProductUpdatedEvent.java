package com.example.inventory_service_query.events;
import com.example.inventory_service_query.enums.ProductState;
import lombok.Getter;
@Getter
public class ProductUpdatedEvent extends BaseEvent<String> {
    private String name;
    private double price;
    private int quantity;
    private ProductState state;
    private String categoryId;

    public ProductUpdatedEvent(String id, String name, double price, int quantity,
                               ProductState state, String categoryId) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.state = state;
        this.categoryId = categoryId;
    }
}
