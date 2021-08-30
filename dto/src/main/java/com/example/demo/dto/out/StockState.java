package com.example.demo.dto.out;

import lombok.Getter;

import java.util.List;

@Getter
public class StockState {

    public enum State {FULL, SOME, EMPTY};

    State state;
    List<ShoeQuantity> shoeQuantities;

    public void setState(State state) {
        this.state = state;
    }

}
