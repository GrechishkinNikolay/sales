package com.grechishkin.sales.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@Entity
@Table(name = "actuals")
@Getter
@Setter
public class Actual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @NotNull
    @Column(name = "date", columnDefinition = "timestamp with time zone default now()")
    //TODO "Проверить без columnDefinition"
    private OffsetDateTime date;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "material_no",
            referencedColumnName = "material_no",
            foreignKey = @ForeignKey(name = "fk_actuals_products"))
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "ch3_ship_to_code",
            referencedColumnName = "ch3_ship_to_code",
            foreignKey = @ForeignKey(name = "fk_actuals_customers"))
    private Customer customer;

    @NotNull
    @Column(name = "chain_name")
    private String chainName;

    @NotNull
    @Column(name = "units")
    private Integer units;

    @NotNull
    @Column(name = "actual_sales_value")
    private BigDecimal actualSalesValue;

    @NotNull
    @Column(name = "is_promo", columnDefinition = "boolean default false")
    private boolean isPromo = false;
}
