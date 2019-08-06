package com.egorius.rawstory.controllers;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class ImagesController {
    private static final String resource = "L:\\IdeaProjects\\raw-story\\src\\main\\resources\\static";

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
        File file = new File(resource.concat("\\" + id).concat(".jpg"));

        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytes = IOUtils.toByteArray(in);
            return new ResponseEntity<>(bytes, HttpStatus.OK);
        } catch (IOException ex) {
            return new ResponseEntity<>(new byte[]{}, HttpStatus.NO_CONTENT);
        }
    }
}
