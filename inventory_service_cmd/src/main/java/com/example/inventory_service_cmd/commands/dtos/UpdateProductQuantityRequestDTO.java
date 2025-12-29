package com.example.inventory_service_cmd.commands.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductQuantityRequestDTO {
    private String productId;
    private int quantity;
}
