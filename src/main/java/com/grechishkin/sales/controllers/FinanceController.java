package com.grechishkin.sales.controllers;

import com.grechishkin.sales.dto.PriceDTO;
import com.grechishkin.sales.entities.Price;
import com.grechishkin.sales.services.PriceService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class FinanceController {


    private final PriceService priceService;

    // Get all prices
    @GetMapping("/")
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }

    // Get a specific price by id
    @GetMapping("/{id}")
    public Price getPriceById(@PathVariable(value = "id") Long priceId) {
        return priceService.getPriceById(priceId);
    }

    // Create a new price
    @PostMapping("/")
    public Price createPrice(@Valid @RequestBody PriceDTO priceDTO) {
        return priceService.createPrice(priceDTO);
    }

    // Update an existing price
    @Transactional
    @PutMapping("/{id}")
    public Price updatePrice(@PathVariable(value = "id") Long priceId,
                             @Valid @RequestBody PriceDTO priceDTO) {
        Price price = priceService.updatePrice(priceId, priceDTO);
        return price;
    }

    // Delete a price
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable(value = "id") Long priceId) {
        priceService.deletePrice(priceId);
        return ResponseEntity.ok().build();
    }
}
