package com.example.inventory_service_cmd.commands.dtos;

import com.example.inventory_service_cmd.enums.ProductState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductStateRequestDTO {
    private String productId;
    private ProductState state;
}
