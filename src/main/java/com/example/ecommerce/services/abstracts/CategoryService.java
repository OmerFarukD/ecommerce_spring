package com.example.ecommerce.services.abstracts;


import com.example.ecommerce.dtos.categgories.CategoryAddRequestDto;
import com.example.ecommerce.dtos.categgories.CategoryResponseDto;
import com.example.ecommerce.dtos.categgories.CategoryUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    List<CategoryResponseDto> getAll();
    CategoryResponseDto getById(Long id);

    String delete(long id);

    String add(CategoryAddRequestDto dto);
    String update(CategoryUpdateRequestDto dto);

}
