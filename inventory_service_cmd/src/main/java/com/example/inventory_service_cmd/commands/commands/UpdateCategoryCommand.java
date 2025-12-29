package com.example.inventory_service_cmd.commands.commands;

import com.example.inventory_service_cmd.enums.ProductState;
import lombok.Getter;

@Getter
public class UpdateCategoryCommand extends BaseCommand<String> {
    private String name;
    private String description;

    public UpdateCategoryCommand(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
