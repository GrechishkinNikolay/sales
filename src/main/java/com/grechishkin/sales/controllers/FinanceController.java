package com.grechishkin.sales.controllers;

import com.grechishkin.sales.entities.Price;
import com.grechishkin.sales.repositories.PriceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class FinanceController {

    private final PriceRepository priceRepository;

    // Get all prices
    @GetMapping("/")
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    // Get a specific price by id
    @GetMapping("/{id}")
    public Price getPriceById(@PathVariable(value = "id") Long priceId) {
        return priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Price Id = {}", priceId)));
    }

    // Create a new price
    @PostMapping("/")
    public Price createPrice(@Valid @RequestBody Price price) {
        return priceRepository.save(price);
    }

    // Update an existing price
//    @PutMapping("/{id}")
//    public Price updatePrice(@PathVariable(value = "id") Long priceId,
//                             @Valid @RequestBody Price priceDetails) {
//        Price price = priceRepository.findById(priceId)
//                .orElseThrow(() -> new EntityNotFoundException(String.format("Price Id = {}", priceId)));
//
//        price.setMaterialNo(priceDetails.getMaterialNo());
//        price.setChainName(priceDetails.getChainName());
//        price.setRegularPricePerUnit(priceDetails.getRegularPricePerUnit());
//
//        Price updatedPrice = priceRepository.save(price);
//        return updatedPrice;
//    }

    // Delete a price
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable(value = "id") Long priceId) {
        Price price = priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Price Id = {}", priceId)));

        priceRepository.delete(price);

        return ResponseEntity.ok().build();
    }
}
