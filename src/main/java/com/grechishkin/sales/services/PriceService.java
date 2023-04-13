package com.grechishkin.sales.services;

import com.grechishkin.sales.entities.Price;
import com.grechishkin.sales.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Price getFirstPrice() {
        return priceRepository.findById(1L).orElseThrow(IllegalStateException::new);
    }

}
