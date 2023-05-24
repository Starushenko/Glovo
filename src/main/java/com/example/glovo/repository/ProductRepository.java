package com.example.glovo.repository;

import com.example.glovo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByOrder(int order);
}
