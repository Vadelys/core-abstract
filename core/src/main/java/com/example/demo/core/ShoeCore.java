package com.example.demo.core;

import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.in.ShoeStockMovement;
import com.example.demo.dto.out.Shoes;
import com.example.demo.dto.out.StockState;
import com.example.demo.entity.Stock;

public interface ShoeCore {

  Shoes search(ShoeFilter filter);

  void update(ShoeStockMovement shoeStockMovement);
  StockState getStock();

}
