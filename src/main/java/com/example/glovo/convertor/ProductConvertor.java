package com.example.glovo.convertor;


import com.example.glovo.entity.ProductEntity;

import com.example.glovo.model.Product;

public class ProductConvertor {

    public static Product productEntityToProduct(ProductEntity productEntity){
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .cost(productEntity.getCost())
                .build();
    }
    public static ProductEntity productToProductEntity(Product product){
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }
}
