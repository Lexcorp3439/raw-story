package com.egorius.rawstory.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ImagesController.class)
public class ImagesControllerTest {

    @SuppressWarnings("unused")  private final static String RESOURCES_ROOT = "L:\\IdeaProjects\\raw-story\\src\\test\\resources";
    private static final String resource = "L:\\IdeaProjects\\raw-story\\src\\main\\resources\\static";

    @Autowired
    private MockMvc mockMvc;

    private final static String PATH = "/images/";
    private final static String existID = "AgADAgADLqsxG7njEUolmPpMNXTZp2Lhug8ABAEAAwIAA3kAA41EAAIWBA";
    private final static String notExistID = "ffffffff";

    @Test
    public void statusTest() throws Exception {
        mockMvc.perform(get(PATH.concat(existID)))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.IMAGE_JPEG));

    }

    @Test
    public void resultTest() throws Exception {
        String getFilePath = PATH.concat(existID);
        File file = new File(resource.concat("\\" + existID).concat(".jpg"));

        mockMvc.perform(get(getFilePath))
                .andExpect(status().isOk());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(getFilePath)
                .accept(MediaType.IMAGE_JPEG)).andReturn();

        try (
                // файл, ктоорый должен отправиться
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))
        ) {
            byte[] img = mvcResult.getResponse().getContentAsByteArray();
            byte[] bytes = IOUtils.toByteArray(in);

            assertArrayEquals(bytes, img);
        }
    }

    @Test
    public void imgNotExistTest() throws Exception {
        String getFilePath = PATH.concat(notExistID);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(getFilePath)
                .accept(MediaType.IMAGE_JPEG)).andExpect(status().isNoContent()).andReturn();

        byte[] img = mvcResult.getResponse().getContentAsByteArray();
        assertArrayEquals(new byte[]{}, img);
    }
}
