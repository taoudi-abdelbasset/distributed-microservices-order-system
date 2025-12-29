package com.example.inventory_service_query.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductsByStateQuery {
    private String state; // AVAILABLE, RUPTURE, PRODUCTION, ABANDON
}
