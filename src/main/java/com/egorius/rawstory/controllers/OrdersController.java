package com.egorius.rawstory.controllers;

import com.egorius.rawstory.bot.ServerBot;
import com.egorius.rawstory.entitys.Cake;
import com.egorius.rawstory.entitys.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrdersController {

    @PostMapping(value = "/new")
    public ResponseEntity<Long> addOrder(@RequestBody Order order) {
        long id  =System.currentTimeMillis();
        order.setId(id);
        ServerBot.serverBot.sendMsg(order.toString());
        System.out.println(order.toString());
        return new ResponseEntity<>(order.getId(), HttpStatus.ACCEPTED);
    }
}
