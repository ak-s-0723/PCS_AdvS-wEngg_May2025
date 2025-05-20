package org.example.pcs_advsoftengg_may2025.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends BaseModel {
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products;

    private String title;

    private String description;
}
