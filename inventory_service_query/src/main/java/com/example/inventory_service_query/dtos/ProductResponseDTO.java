package com.example.inventory_service_query.dtos;
import com.example.inventory_service_query.enums.ProductState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private ProductState state;
    private String categoryId;
}
