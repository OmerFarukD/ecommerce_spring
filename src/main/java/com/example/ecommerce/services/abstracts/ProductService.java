package com.example.ecommerce.services.abstracts;

import com.example.ecommerce.dtos.products.ProductAddRequestDto;
import com.example.ecommerce.dtos.products.ProductResponseDto;
import com.example.ecommerce.dtos.products.ProductUpdateRequestDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAll();
    ProductResponseDto getById(Long id);

    String update(ProductUpdateRequestDto dto);
    String add(ProductAddRequestDto dto);
    String delete(Long id);

}
