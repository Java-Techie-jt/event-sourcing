package com.javatechie.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String orderId;
    private String name;
    private int qty;
    private double price;
    private String userId;

}
