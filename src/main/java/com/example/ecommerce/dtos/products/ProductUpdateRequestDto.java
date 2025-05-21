package com.example.ecommerce.dtos.products;

import com.example.ecommerce.entites.Category;
import com.example.ecommerce.entites.Product;

import java.math.BigDecimal;

public record ProductUpdateRequestDto(Long id,String name, String description, BigDecimal price, Integer stock, Long categoryId) {

    public static Product convertToEntity(ProductUpdateRequestDto dto){

        Product product = new Product(dto.id);
        product.setName(dto.name);
        product.setDescription(dto.description);
        product.setStock(dto.stock);
        product.setPrice(dto.price);
        product.setCategory(new Category(dto.categoryId()));

        return product;
    }
}