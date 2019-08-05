package com.egorius.rawstory.controllers;

import java.io.File;
import java.io.FileOutputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@RunWith(SpringRunner.class)
@WebMvcTest(ImagesController.class)
public class ImagesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final static String PATH = "/images/";

    @Test
    public void statusTest() throws Exception {
        mockMvc.perform(get(PATH.concat("")))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.IMAGE_JPEG));

    }

    @Test
    public void resultTest() throws Exception {
        String id = "";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(PATH.concat(""))
                .accept(MediaType.IMAGE_JPEG)).andReturn();
        byte[] img = mvcResult.getResponse().getContentAsByteArray();
        try(FileOutputStream fos = new FileOutputStream(new File(id.concat(".jpg")))) {
            fos.write(img);
        }
    }

    @Test
    public void imgNotExistTest() throws Exception {
        String id = "";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(PATH.concat(""))
                .accept(MediaType.IMAGE_JPEG)).andReturn();
        byte[] img = mvcResult.getResponse().getContentAsByteArray();
        try(FileOutputStream fos = new FileOutputStream(new File(id.concat(".jpg")))) {
            fos.write(img);
        }
    }
}
