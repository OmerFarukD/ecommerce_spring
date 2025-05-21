package com.example.ecommerce.dtos.categgories;

import com.example.ecommerce.entites.Category;

public record CategoryAddRequestDto(String name, String description) {


    public static Category convertToEntity(CategoryAddRequestDto dto){
        Category category = new Category();
        category.setName(dto.name);
        category.setDescription(dto.description);
        return category;
    }
}
