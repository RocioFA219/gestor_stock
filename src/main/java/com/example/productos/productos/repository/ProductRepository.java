package com.example.productos.productos.repository;

import com.example.productos.productos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByNameIgnoreCase(String name);

    @Query("""
            SELECT p FROM Product p
            WHERE(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))
            AND (:stock is null OR p.stock >= :stock)
            """)
    List<Product>findByNameAndStock(@Param("name") String name,@Param("stock") Integer stock);
}
