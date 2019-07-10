package com.egorius.rawstory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
        service.addNewPost(post);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/add")
    public ResponseEntity<String> addPost() {
        return ResponseEntity.ok("Need POST request");
    }

}
