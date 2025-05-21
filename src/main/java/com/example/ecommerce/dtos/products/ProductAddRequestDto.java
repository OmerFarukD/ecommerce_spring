package com.example.ecommerce.dtos.products;

import com.example.ecommerce.entites.Category;
import com.example.ecommerce.entites.Product;

import java.math.BigDecimal;

public record ProductAddRequestDto(String name, String description, BigDecimal price,Integer stock, Long categoryId) {

    public static Product convertToEntity(ProductAddRequestDto dto){

        Product product = new Product();

        product.setName(dto.name);
        product.setDescription(dto.description);
        product.setStock(dto.stock);
        product.setPrice(dto.price);
        product.setCategory(new Category(dto.categoryId()));

        return product;
    }
}
