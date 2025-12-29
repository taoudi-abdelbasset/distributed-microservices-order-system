package com.example.inventory_service_query.entities;

import com.example.inventory_service_query.enums.ProductState;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductState state;

    @Column(name = "category_id")
    private String categoryId;
}
