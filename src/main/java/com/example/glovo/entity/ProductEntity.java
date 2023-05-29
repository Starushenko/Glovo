package com.example.glovo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("product")
@Data
@Builder
@AllArgsConstructor
public class ProductEntity {
    @Id
    private int id;
    private String name;
    private int cost;
    private int order;
}
