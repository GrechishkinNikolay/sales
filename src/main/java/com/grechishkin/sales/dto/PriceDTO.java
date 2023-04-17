package com.grechishkin.sales.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class PriceDTO {

    @NotNull
    public Integer productNo;

    @NotNull
    public String chainName;

    @NotNull
    public BigDecimal regularPricePerUnit;
}
