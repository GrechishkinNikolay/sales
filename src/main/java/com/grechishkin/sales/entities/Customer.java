package com.grechishkin.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "ch3_ship_to_code")
    private Integer ch3ShipToCode;

    @NotNull
    @Column(name = "ch3_ship_to_name")
    private String ch3ShipToName;

    @NotNull
    @Column(name = "chain_name")
    private String chainName;

}
