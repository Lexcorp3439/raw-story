package com.egorius.rawstory.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egorius.rawstory.bot.ServerBot;
import com.egorius.rawstory.entitys.Post;
import com.egorius.rawstory.services.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private BlogService service;

    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(service.getAllPosts());
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        System.out.println(post.getDate());
        String[] imgPaths = post.getPaths();
        System.out.println(Arrays.toString(imgPaths));
        String[] img = new String[imgPaths.length];

        int i = 0;
        for (String imgP : imgPaths) {
            String path = ServerBot.serverBot.downloadImg(imgP);
            if (path.length() != 0) {
                img[i] = path;
                i++;
            }
        }
        System.out.println(Arrays.toString(img));
        post.setPaths(img);
        service.addNewPost(post);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/add")
    public ResponseEntity<String> addPost() {
        return ResponseEntity.ok("Need POST request");
    }

}
