package com.example.demo.controller;

import com.example.demo.dto.in.ShoeArrival;
import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.out.Shoes;
import com.example.demo.dto.out.Stock;
import com.example.demo.facade.ShoeFacade;
import lombok.RequiredArgsConstructor;
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

  @GetMapping(path = "/stock")
  public ResponseEntity<Stock> get(@RequestHeader Integer version) {
    // TODO
    return null;
  }

  @PatchMapping(path = "/stock")
  public ResponseEntity<Stock> get(ShoeArrival shoeArrival, @RequestHeader Integer version) {
    // TODO
    return null;
  }

}
