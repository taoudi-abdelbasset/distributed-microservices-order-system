package com.example.inventory_service_cmd.commands.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductPriceRequestDTO {
    private String productId;
    private double price;
}
