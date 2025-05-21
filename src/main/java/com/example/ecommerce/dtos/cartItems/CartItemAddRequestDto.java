package com.example.ecommerce.dtos.cartItems;

public record CartItemAddRequestDto(Long cartId, Long productId,Integer quantity ) {
}
