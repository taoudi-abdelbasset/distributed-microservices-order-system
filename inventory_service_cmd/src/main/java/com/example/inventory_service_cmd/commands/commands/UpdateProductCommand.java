package com.example.inventory_service_cmd.commands.commands;

import com.example.inventory_service_cmd.enums.ProductState;
import lombok.Getter;

@Getter
public class UpdateProductCommand extends BaseCommand<String> {
    private String name;
    private double price;
    private int quantity;
    private ProductState state;
    private String categoryId;

    public UpdateProductCommand(String id, String name, double price, int quantity,
                                ProductState state, String categoryId) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.state = state;
        this.categoryId = categoryId;
    }
}
