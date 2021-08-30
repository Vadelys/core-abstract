package com.example.demo.mapper;

import com.example.demo.dto.in.ShoeStockMovement;
import com.example.demo.dto.out.ShoeQuantity;
import com.example.demo.dto.out.StockState;
import com.example.demo.entity.ShoeStock;
import com.example.demo.entity.Stock;
import org.mapstruct.factory.Mappers;

import java.math.BigInteger;
import java.util.Optional;

@org.mapstruct.Mapper
public interface ShoeMapper {

    ShoeMapper INSTANCE = Mappers.getMapper( ShoeMapper.class );

    ShoeStock ssMvtTosStock(ShoeStockMovement shoeStockMovement);

    StockState stockToStockState(Stock stock);

}
