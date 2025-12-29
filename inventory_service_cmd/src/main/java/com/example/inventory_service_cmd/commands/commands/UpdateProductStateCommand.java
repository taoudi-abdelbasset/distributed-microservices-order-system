package com.example.inventory_service_cmd.commands.commands;
import com.example.inventory_service_cmd.enums.ProductState;
import lombok.Getter;
@Getter
public class UpdateProductStateCommand extends BaseCommand<String> {
    private ProductState state;

    public UpdateProductStateCommand(String id, ProductState state) {
        super(id);
        this.state = state;
    }
}