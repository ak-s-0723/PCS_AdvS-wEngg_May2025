package org.example.pcs_advsoftengg_may2025.services;

import org.example.pcs_advsoftengg_may2025.models.Category;
import org.example.pcs_advsoftengg_may2025.models.Product;
import org.example.pcs_advsoftengg_may2025.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sps")
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getSingleProductDetail(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if(productOptional.isPresent()) return productOptional.get();

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        Product product = new Product();
        product.setName(title);
        product.setDescription(description);
        product.setImageUrl(image);
        Category newCat = new Category();
        newCat.setTitle(category);
        product.setCategory(newCat);
        product.setPrice(price);
        return  productRepo.save(product);
    }
}
