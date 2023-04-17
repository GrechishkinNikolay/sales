package com.grechishkin.sales.services;

import com.grechishkin.sales.dto.PriceDTO;
import com.grechishkin.sales.entities.Price;
import com.grechishkin.sales.entities.Product;
import com.grechishkin.sales.mappers.PriceMapper;
import com.grechishkin.sales.repositories.PriceRepository;
import com.grechishkin.sales.repositories.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;
    private final ProductsRepository productsRepository;

    @Transactional(readOnly = true)
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Price getPriceById(Long priceId) {
        return priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Price Id = {}", priceId)));
    }

    @Transactional
    public Price createPrice(PriceDTO priceDTO) {
        Product product = productsRepository
                .findById(priceDTO.productNo)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product Id = {}", priceDTO.productNo)));

        Price price = PriceMapper.INSTANCE.toPrice(priceDTO, product);

        return priceRepository.save(price);
    }

    @Transactional
    public Price updatePrice(Long priceId, PriceDTO priceDTO) {
        Product product = productsRepository
                .findById(priceDTO.productNo)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product Id = {}", priceDTO.productNo)));

        Price price = priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Price Id = {}", priceId)));

        price.setProduct(product);
        price.setChainName(priceDTO.chainName);
        price.setRegularPricePerUnit(priceDTO.regularPricePerUnit);

        return price;
    }

    @Transactional
    public ResponseEntity<?> deletePrice(Long priceId) {
        Price price = priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Price Id = {}", priceId)));

        priceRepository.delete(price);
        return ResponseEntity.ok().build();
    }
}
