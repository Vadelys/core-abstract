package com.example.demo.entity;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

// I voluntarly chose not to make Stock an Entity,
// because it's global and the only usefull data is contained within the ShoesQuantity lines
public class Stock {

    private static Stock instance;

    private Stock() {
        //TODO
    }

    public final static Stock getInstance() {
        if (Stock.instance == null) {
            synchronized(Stock.class) {
                if (Stock.instance == null) {
                    Stock.instance = new Stock();
                }
            }
        }
        return Stock.instance;
    }

    public final static BigInteger MAX_SIZE = BigInteger.valueOf(30);

    List<ShoeStock> shoeStocks;

    public Stock addShoesToStock(ShoeStock shoeQuantityToAdd) {

        if(shoeQuantityToAdd.getQuantity().add(BigInteger.valueOf(shoeStocks.size())).compareTo(MAX_SIZE)==1) {
            throw new IllegalArgumentException("Impossible to add shoes to the store, max capacity would be exceeded.");
        }
        Optional<ShoeStock> shoeStockAlreadyInStock = shoeStocks.stream().filter(it -> it.getShoe().equals(shoeQuantityToAdd.getShoe())).findFirst();
        if(shoeStockAlreadyInStock.isPresent()) {
            ShoeStock shoeQuantityInStock = shoeStockAlreadyInStock.get();
            shoeQuantityInStock.addQuantity(shoeQuantityToAdd.getQuantity());
        } else {
            shoeStocks.add(shoeQuantityToAdd);
        }

        return this;

        //TODO Rajouter la sauvegarde en base

    }

}
