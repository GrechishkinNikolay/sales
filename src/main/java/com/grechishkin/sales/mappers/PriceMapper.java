package com.grechishkin.sales.mappers;

import com.grechishkin.sales.dto.PriceDTO;
import com.grechishkin.sales.entities.Price;
import com.grechishkin.sales.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    PriceDTO toDTO(Price price);

//    @Mapping(source = "product", target = ".")
    Price toPrice(PriceDTO priceDTO, Product product);

}
