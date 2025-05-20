package org.example.pcs_advsoftengg_may2025.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductRequestDTO {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
