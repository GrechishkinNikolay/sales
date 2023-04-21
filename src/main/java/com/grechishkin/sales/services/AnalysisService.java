package com.grechishkin.sales.services;

import com.grechishkin.sales.entities.Actual;
import com.grechishkin.sales.entities.Product;
import com.grechishkin.sales.repositories.ActualsRepository;
import com.grechishkin.sales.repositories.PriceRepository;
import com.grechishkin.sales.repositories.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final PriceRepository priceRepository;
    private final ProductsRepository productsRepository;
    private final ActualsRepository actualsRepository;

    @Transactional(readOnly = true)
    public List<Actual> getAllActuals() {
        return actualsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Actual> getActualsByChainNamesAndProductsAndDate(
            List<String> chainNames,
            List<Integer> productsNumbers,
            OffsetDateTime date) {

        List<Product> products = productsRepository.findAllById(productsNumbers);

        products.stream().findAny().orElseThrow(() ->
                new EntityNotFoundException(String.format("Products Id = {}", productsNumbers
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")))));

        return actualsRepository.findByChainNameInAndProductInAndDate(chainNames, products, date);
    }
}
