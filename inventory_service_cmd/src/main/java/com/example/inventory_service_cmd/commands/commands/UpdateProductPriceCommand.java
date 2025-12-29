package com.example.inventory_service_cmd.commands.commands;
import com.example.inventory_service_cmd.enums.ProductState;
import lombok.Getter;

@Getter
public class UpdateProductPriceCommand extends BaseCommand<String> {
    private double price;

    public UpdateProductPriceCommand(String id, double price) {
        super(id);
        this.price = price;
    }
}