package org.example.pcs_advsoftengg_may2025.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.pcs_advsoftengg_may2025.models.Product;
import org.example.pcs_advsoftengg_may2025.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//These are the unit tests for your endpoints which cannot be tested
// through ProductControllerTest
@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void Test_GetAllProducts_RunSuccessfully() throws Exception {

        //Arrange
        Long id  = 2L;
        Product product = new Product();
        product.setId(id);
        product.setName("Iphone");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productService.getAllProducts()).thenReturn(productList);

        String expectedReponse = objectMapper.writeValueAsString(productList);
        System.out.println(expectedReponse);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedReponse));
    }

}


//{
//    "id" : 2
//        "name" : "diwhdiwq"
//}