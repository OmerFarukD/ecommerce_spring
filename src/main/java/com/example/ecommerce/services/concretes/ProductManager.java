package com.example.ecommerce.services.concretes;

import com.example.ecommerce.dtos.products.ProductAddRequestDto;
import com.example.ecommerce.dtos.products.ProductResponseDto;
import com.example.ecommerce.dtos.products.ProductUpdateRequestDto;
import com.example.ecommerce.entites.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.services.abstracts.ProductService;
import com.example.ecommerce.utils.exceptions.types.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {

private final ProductRepository productRepository;
private final ModelMapper modelMapper;

    public ProductManager(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductResponseDto> getAll() {

        List<Product> products = this.productRepository.findAll();
        return products.stream().map(ProductResponseDto::convertToResponseDto).collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getById(Long id) {
        Product product = this.productRepository.findById(id).orElseThrow(()-> new NotFoundException("Ürün Bulunamadı."));
        return modelMapper.map(product,ProductResponseDto.class);
    }

    @Override
    public String update(ProductUpdateRequestDto dto) {
        return null;
    }

    @Override
    public String add(ProductAddRequestDto dto) {
       Product product = ProductAddRequestDto.convertToEntity(dto);
       this.productRepository.save(product);
       return "Ürün eklendi.";
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
