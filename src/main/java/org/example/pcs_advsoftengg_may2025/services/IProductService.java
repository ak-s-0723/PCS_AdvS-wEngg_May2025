package org.example.pcs_advsoftengg_may2025.services;

import org.example.pcs_advsoftengg_may2025.models.Product;

import java.util.List;

public interface IProductService {
    Product getSingleProductDetail(Long id);

    List<Product> getAllProducts();

    Product createProduct(String title,
                          String description,
                          String image,
                          String category,
                          double price);
}
