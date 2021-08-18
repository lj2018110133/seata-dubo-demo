package com.example.orderservice.contorller;

import com.example.orderservice.orderImpl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@RequestMapping("/seata/order")
public class OrderContorller {


    @Autowired
    private OrderService orderService;

    @RequestMapping("/index")
    @ResponseBody
    public boolean creataOrder(int num, String id) throws SQLException {
       return orderService.creataOrder(num,id);
    }
}
