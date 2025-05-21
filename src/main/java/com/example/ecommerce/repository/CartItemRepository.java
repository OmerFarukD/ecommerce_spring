package com.example.ecommerce.repository;

import com.example.ecommerce.entites.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findByCartId(Long cartId);
    boolean existsByCartIdAndProductId(Long cartId, Long productId);

}
