package com.example.inventory_service_cmd.commands.commands;
import com.example.inventory_service_cmd.enums.ProductState;
import lombok.Getter;

@Getter
public class DeleteProductCommand extends BaseCommand<String> {
    public DeleteProductCommand(String id) {
        super(id);
    }
}
