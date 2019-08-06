package com.egorius.rawstory.controllers;

import com.egorius.rawstory.entitys.Cake;
import com.egorius.rawstory.entitys.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrdersController.class)
public class OrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final static String PATH = "/order";

    @Test
    public void sendNewOrder() throws Exception {
        String path = PATH.concat("/new");

        List<Cake> cakes = new ArrayList<>();
        cakes.add(new Cake("Вкусный", 1, 2d, "Шоколадный", "Клубника", "Манго", "Карамель"));
        Order order = new Order(cakes, "+78889992345", "Сегодня", "Доставка быстраа", new BigDecimal(345));

        mockMvc.perform(MockMvcRequestBuilders
                .post(path)
                .content(asJsonString(order))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}