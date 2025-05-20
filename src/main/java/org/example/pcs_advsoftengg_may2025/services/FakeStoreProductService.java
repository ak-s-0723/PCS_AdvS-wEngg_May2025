package org.example.pcs_advsoftengg_may2025.services;

import org.example.pcs_advsoftengg_may2025.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fkps")
public class FakeStoreProductService implements IProductService {
    @Override
    public Product getSingleProductDetail(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        return null;
    }
}
