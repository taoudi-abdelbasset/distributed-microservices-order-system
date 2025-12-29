package com.example.inventory_service_cmd.commands.commands;
import com.example.inventory_service_cmd.enums.ProductState;
import lombok.Getter;

@Getter
public class UpdateProductQuantityCommand extends BaseCommand<String> {
    private int quantity;

    public UpdateProductQuantityCommand(String id, int quantity) {
        super(id);
        this.quantity = quantity;
    }
}