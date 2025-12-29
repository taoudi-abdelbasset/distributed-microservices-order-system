package com.example.inventory_service_query.entities;
import com.example.inventory_service_query.enums.ProductState;
import jakarta.persistence.*;
import lombok.*;

// ==================== CATEGORY ENTITY ====================

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;
}