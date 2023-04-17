package com.grechishkin.sales.services;

import com.grechishkin.sales.entities.Actual;
import com.grechishkin.sales.repositories.ActualsRepository;
import com.grechishkin.sales.repositories.PriceRepository;
import com.grechishkin.sales.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

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
            List<Integer> products,
            OffsetDateTime date) {

        return actualsRepository.findByChainNameInAndProductInAndDate(chainNames, products, date);
    }
}
