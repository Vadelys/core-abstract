package com.example.demo.dto.out;

import lombok.Builder;
import lombok.Value;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Value
@Builder
public class Stock {

    private enum State {SOME,EMPTY,FULL}

    final static BigInteger MAX_SIZE = BigInteger.valueOf(30);

    State state;
    List<ShoeQuantity> shoeQuantities;

    public State addShoesToStock(ShoeQuantity shoeQuantityToAdd) {

        if(state == State.FULL ||
            shoeQuantityToAdd.getQuantity().add(BigInteger.valueOf(shoeQuantities.size())).compareTo(MAX_SIZE)==1) {
            throw new IllegalArgumentException("Impossible to add shoes to the store, max capacity would be exceeded.");
        }
        Optional<ShoeQuantity> shoeQuantityAlreadyInStock = shoeQuantities.stream().filter(it -> it.getShoe() == shoeQuantityToAdd.getShoe()).findFirst();
        if(shoeQuantityAlreadyInStock.isPresent()) {
            ShoeQuantity shoeQuantityInStock = shoeQuantityAlreadyInStock.get();
            shoeQuantityInStock.setQuantity(shoeQuantityInStock.getQuantity().add(shoeQuantityToAdd.getQuantity()));
        } else {
            shoeQuantities.add(shoeQuantityToAdd);
        }

        return this.state;
    }

}
