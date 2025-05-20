package org.example.pcs_advsoftengg_may2025.controllers;


import org.example.pcs_advsoftengg_may2025.dtos.CreateProductRequestDTO;
import org.example.pcs_advsoftengg_may2025.models.Product;
import org.example.pcs_advsoftengg_may2025.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    //@Qualifier("sps")
    private IProductService productService;

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable Long id) {
        if(id < 0) {
            throw new IllegalArgumentException("Please pass productId greater than 0");
        }

        return productService.getSingleProductDetail(id);
    }

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        return productService.createProduct(createProductRequestDTO.getTitle(),
                createProductRequestDTO.getDescription(),
                createProductRequestDTO.getImage(),
                createProductRequestDTO.getCategory(),
                createProductRequestDTO.getPrice());
    }
}