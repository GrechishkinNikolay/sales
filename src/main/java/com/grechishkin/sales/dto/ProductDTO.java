package com.grechishkin.sales.dto;

import jakarta.validation.constraints.NotNull;

public class ProductDTO {

    @NotNull
    private Integer materialNo;

    @NotNull
    private String materialDescRus;

    @NotNull
    private Integer l3ProductCategoryCode;

    @NotNull
    private String l3ProductCategoryName;
}
