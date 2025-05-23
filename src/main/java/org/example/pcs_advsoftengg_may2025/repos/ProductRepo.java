package org.example.pcs_advsoftengg_may2025.repos;

import org.example.pcs_advsoftengg_may2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Product save(Product p);
    Optional<Product> findById(Long id);

    List<Product> findAll();
}
