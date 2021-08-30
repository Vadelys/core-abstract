package com.example.demo.dto.out;

import com.example.demo.dto.in.ShoeFilter;
import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Builder
@Getter
public class ShoeQuantity {

    private BigInteger size;
    private ShoeFilter.Color color;
    private BigInteger quantity;

}