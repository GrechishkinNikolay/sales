package com.grechishkin.sales.controllers;

import com.grechishkin.sales.entities.Actual;
import com.grechishkin.sales.services.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class AnalysisController {
    /*
    - выгрузка фактов продаж с учётом признака промо, он должен возвращать все справочные поля:
    -сеть,
    -категория,
    месяц,
    факт продаж в штуках по базовой цене,
    факт продаж по промо цене,
    доля продаж по промо, %.
    - выгрузка фактов по дням, согласно фильтрации по списку наименований сетей и списку продуктов
    */
    private final AnalysisService analysisService;

    // Get all Actuals
    @GetMapping("/")
    public List<Actual> getAllActuals() {
        return analysisService.getAllActuals();
    }

    // Get a specific Actuals
    @GetMapping("/filtered-actuals")
    public List<Actual> getActualsByChainNamesAndProductsAndDate(@RequestBody List<String> chainNames,
                                                                 @RequestBody List<Integer> products,
                                                                 @RequestBody OffsetDateTime date) {
        return analysisService.getActualsByChainNamesAndProductsAndDate(chainNames, products, date);
    }
}
