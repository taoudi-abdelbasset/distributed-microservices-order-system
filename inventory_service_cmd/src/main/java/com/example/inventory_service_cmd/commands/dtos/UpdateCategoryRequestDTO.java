package com.example.inventory_service_cmd.commands.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequestDTO {
    private String categoryId;
    private String name;
    private String description;
}