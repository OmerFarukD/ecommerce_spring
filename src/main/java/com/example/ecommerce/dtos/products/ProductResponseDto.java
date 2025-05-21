package com.example.ecommerce.dtos.products;

import com.example.ecommerce.entites.Product;

import java.math.BigDecimal;

public record ProductResponseDto(Long id, String name, String description, BigDecimal price, Integer stock,String categoryName) {

    public static ProductResponseDto convertToResponseDto(Product product){
        String categoryName = null;
        if (product.getCategory() != null) {
            categoryName = product.getCategory().getName();
        }
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                categoryName
        );
    }
}
