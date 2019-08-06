package com.egorius.rawstory.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TelegramBotController.class)
public class TelegramBotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final static String PATH = "/reg";

    @Test
    public void registrationChatId() throws Exception {
        String path = PATH.concat("/{id}");
        mockMvc.perform(put(path, 3242)).andExpect(status().isOk());
    }
    @Test
    public void registrationBadChatId() throws Exception {
        String path = PATH.concat("/{id}");
        mockMvc.perform(put(path, "sdfewf")).andExpect(status().isBadRequest());
    }

}
