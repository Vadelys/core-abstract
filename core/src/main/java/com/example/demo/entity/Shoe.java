package com.example.demo.entity;

import javax.persistence.Embeddable;
import java.math.BigInteger;

@Embeddable
public class Shoe {

    private String name;
    private BigInteger size;
    private String color;

}
