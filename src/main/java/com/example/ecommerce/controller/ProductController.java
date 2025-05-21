package com.example.ecommerce.controller;

import com.example.ecommerce.dtos.products.ProductAddRequestDto;
import com.example.ecommerce.dtos.products.ProductResponseDto;
import com.example.ecommerce.services.abstracts.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody ProductAddRequestDto dto){
        return ResponseEntity.ok(productService.add(dto));

    }
}
