package com.example.inventory_service_cmd.commands.dtos;

import com.example.inventory_service_cmd.enums.ProductState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for creating a new product
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDTO {
    private String name;
    private double price;
    private int quantity;
    private ProductState state;
    private String categoryId;
}