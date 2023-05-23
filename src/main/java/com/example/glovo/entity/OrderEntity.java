package com.example.glovo.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("order")
@Data
@Builder
public class OrderEntity {
    @Id
    private int id;
    private String date;
    private int cost;
}
