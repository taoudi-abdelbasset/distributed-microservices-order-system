package com.example.inventory_service_query.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEvent<T> {
    private T id;
}
