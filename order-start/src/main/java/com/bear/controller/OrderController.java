package com.bear.controller;

import com.bear.ProductOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    public ProductOrderService productOrderService;

    @PostMapping("PlaceAnOrder")
    public String PlaceAnOrder(@RequestParam("user_id")String userId,@RequestParam("product_id")String productId ){
        productOrderService.save(userId, productId);
        return "SUCCESS";
    }
}
