package org.example.pcs_advsoftengg_may2025.controllers;

import org.example.pcs_advsoftengg_may2025.models.Product;
import org.example.pcs_advsoftengg_may2025.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockBean
    IProductService productService;

    @Test
    public void Test_GetProductDetailsWithPositiveId_ReturnsProductSuccessfully() {
        //Arrange
        Long id  = 2L;
        Product product = new Product();
        product.setId(id);
        product.setName("Iphone");

        when(productService.getSingleProductDetail(id)).thenReturn(product);

        //Act
        Product response = productController.getProductDetails(id);

        //Assert
        assertNotNull(response);
        assertEquals(product.getName(),response.getName());
        assertEquals(id,response.getId());
    }


}