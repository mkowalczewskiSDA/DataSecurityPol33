package com.example.DataSecurity.controller;

import com.example.DataSecurity.repository.OrderRepository;
import com.example.DataSecurity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/list")
    public String getOrders() {
        orderService.getAllOrders().forEach(order -> System.out.println(order.getTitle()));
        return "orders";
    }

}
