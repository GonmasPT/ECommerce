package org.example.ecomproj.repo;

import org.example.ecomproj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    // JPQL
    @Query("SELECT p FROM Product p WHERE " +
           "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " + // Use : to access method parameter
           "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " + // Use '%' before and after the keyword
           "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " + // in case there is text before/after keyword
           "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);
}
