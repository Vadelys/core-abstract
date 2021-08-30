package com.example.demo.controller;

import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.in.ShoeStockMovement;
import com.example.demo.dto.out.Shoes;
import com.example.demo.dto.out.StockState;
import com.example.demo.facade.ShoeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/shoes")
@RequiredArgsConstructor
public class ShoeController {

  private final ShoeFacade shoeFacade;

  @GetMapping(path = "/search")
  public ResponseEntity<Shoes> all(ShoeFilter filter, @RequestHeader Integer version){

    return ResponseEntity.ok(shoeFacade.get(version).search(filter));

  }

  /**
   * Provides the current state of the stock of shoes
   * @param version the version of the service to use
   * @return the current state of the stock
   */
  @GetMapping(path = "/stock")
  public ResponseEntity<StockState> get(@RequestHeader Integer version) {
    return ResponseEntity.ok(shoeFacade.get(version).getStock());
  }

  /**
   * Updates the stock of shoes with a batch of differents quantities of shoes
   * @param shoeStockMovement the list of shoes and their respective quantities
   * @param version the version of the service to use
   * @return the current state of the stock
   */
  @PatchMapping(path = "/stock")
  public ResponseEntity<StockState> update(ShoeStockMovement shoeStockMovement, @RequestHeader Integer version) {
    try {
      shoeFacade.get(version).update(shoeStockMovement);
      // I choose to return the current state of the stock
      // It was not needed according to the ticket, but I found this data usefull. I will ask tomorrow to PO if this is needed.
      return ResponseEntity.ok(shoeFacade.get(version).getStock());
    } catch (IllegalArgumentException exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}
