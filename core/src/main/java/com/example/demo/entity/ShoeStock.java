package com.example.demo.entity;

import com.example.demo.dto.in.ShoeFilter;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
public class ShoeStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Shoe shoe;
    private BigInteger quantity;

    public void addQuantity(BigInteger quantity) {
        this.quantity = this.quantity.add(quantity);
    }

}
