package com.example.demo.dto.in;


import com.example.demo.dto.out.ShoeQuantity;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ShoeArrival {

    List<ShoeQuantity> shoeQuantities;

}
