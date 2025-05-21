package com.example.ecommerce.dtos.cartItems;

public record CartItemResponseDto(Long id,Long cartId, String productName,Integer quantity) {
}
