package com.example.inventory_service_cmd.commands.commands;

import com.example.inventory_service_cmd.enums.ProductState;
import lombok.Getter;

@Getter
public class DeleteCategoryCommand extends BaseCommand<String> {
    public DeleteCategoryCommand(String id) {
        super(id);
    }
}
