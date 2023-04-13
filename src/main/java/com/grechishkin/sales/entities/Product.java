package com.grechishkin.sales.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Setter
@Getter
public class Product {

    @Id
    @Column(name = "material_no")
    private Integer materialNo;

    @NotNull
    @Column(name = "material_desc_rus")
    private String materialDescRus;

    @NotNull
    @Column(name = "l3_product_category_code")
    private Integer l3ProductCategoryCode;

    @NotNull
    @Column(name = "l3_product_category_name")
    private String l3ProductCategoryName;
}
