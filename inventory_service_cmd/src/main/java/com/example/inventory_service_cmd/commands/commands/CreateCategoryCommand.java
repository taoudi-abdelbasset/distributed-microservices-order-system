package com.example.inventory_service_cmd.commands.commands;

import lombok.Getter;
@Getter
public class CreateCategoryCommand extends BaseCommand<String> {
    private String name;
    private String description;

    public CreateCategoryCommand(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
