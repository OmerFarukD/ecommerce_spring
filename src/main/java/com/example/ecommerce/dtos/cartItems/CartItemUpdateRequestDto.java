package com.example.ecommerce.dtos.cartItems;

public record CartItemUpdateRequestDto(Long id,Long cartId, Long productId,Integer quantity) {
}
