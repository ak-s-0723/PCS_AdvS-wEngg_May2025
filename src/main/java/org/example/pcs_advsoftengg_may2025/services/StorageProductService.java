package org.example.pcs_advsoftengg_may2025.services;

import org.example.pcs_advsoftengg_may2025.dtos.UserDto;
import org.example.pcs_advsoftengg_may2025.models.Category;
import org.example.pcs_advsoftengg_may2025.models.Product;
import org.example.pcs_advsoftengg_may2025.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service("sps")
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;


    @Autowired
    private RestTemplate restTemplate;

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

    @Override
    public Product getDetailsBasedOnUserScope(Long productId, Long userId) {
        Optional<Product> optionalProduct = productRepo.findById(productId);

        if(optionalProduct.isEmpty()) {
            System.out.println("NO PRODUCT FOUND");
            return null;
        }

        //check for product scope - public or private and
        //accordingly add if else conditions

        //Call to UserService to get User Detail
        //if user is not null, we will return product , else return null;
        UserDto userDto = restTemplate.getForObject("http://userservice/users/{userId}",UserDto.class,userId);

        if(userDto == null) {
            System.out.println("NO USER DETAIL FOUND");
            return null;
        }

        System.out.println(userDto.getEmail());
        return optionalProduct.get();
    }
}
