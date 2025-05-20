package org.example.pcs_advsoftengg_may2025.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel {
    private String name;

    private String description;

    private double price;

    private String imageUrl;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Category category;
}
