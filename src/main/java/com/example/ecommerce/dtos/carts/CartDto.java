package com.example.ecommerce.dtos.carts;

import com.example.ecommerce.dtos.cartItems.CartItemResponseDto;

import java.math.BigDecimal;
import java.util.List;

public record CartDto(
        Long id,
        Long userId,
        List<CartItemResponseDto> items,
        BigDecimal total) { }