package org.wesley.ecommerce.application.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wesley.ecommerce.application.domain.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
