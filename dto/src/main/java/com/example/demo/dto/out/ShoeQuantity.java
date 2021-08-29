package com.example.demo.dto.out;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.math.BigInteger;

@Builder
@Getter
public class ShoeQuantity {

    Shoe shoe;
    private BigInteger quantity;

    void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

}
