package com.example.ecommerce.dtos.categgories;

import com.example.ecommerce.entites.Category;

public record CategoryResponseDto(Long id, String name, String description) {

    public static CategoryResponseDto convertToResponseDto(Category category){
        return new CategoryResponseDto(category.getId(),category.getName(),category.getDescription());
    }
}
