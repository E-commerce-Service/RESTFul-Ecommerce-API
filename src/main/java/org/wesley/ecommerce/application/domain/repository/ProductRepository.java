package org.wesley.ecommerce.application.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.wesley.ecommerce.application.domain.model.Product;
import org.wesley.ecommerce.application.domain.model.ProductCategory;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.* FROM product AS p JOIN cart_item AS ci ON p.id = ci.product_id WHERE ci.cart_id = ?1", nativeQuery = true)
    List<Product> findProductsByCart(Long cartId);

    Product findProductByCode(String code);

    @Modifying
    @Query(value = "UPDATE product SET rating = ?1, total_reviews = ?2 WHERE code = ?3", nativeQuery = true)
    void updateProductRating(Double newRating, Integer totalReviews, String productCode);

    Page<Product> findProductsByCategory(ProductCategory category, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE " +
            "(LOWER(p.name) LIKE LOWER(:name)) AND " +
            "(:category IS NULL OR p.category = :category) AND " +
            "(:onlyActive = false OR (p.deleted = false AND p.isAvailable = true))")
    Page<Product> findWithFilters(
            @Param("name") String name,
            @Param("category") ProductCategory category,
            @Param("onlyActive") boolean onlyActive,
            Pageable pageable
    );
}
