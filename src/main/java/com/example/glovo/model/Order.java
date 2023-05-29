package com.example.glovo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Order {
    @Id
    private int id;
    private String date;
    private int cost;
    private List<Product> products;
}
