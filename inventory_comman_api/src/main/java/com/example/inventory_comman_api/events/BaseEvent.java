package com.example.inventory_comman_api.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEvent<T> {
    private T id;
}
