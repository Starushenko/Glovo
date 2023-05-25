package com.example.glovo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
public class Product {
    @Id
    private int id;
    private String name;
    private int cost;
}
