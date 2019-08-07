package com.egorius.rawstory.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egorius.rawstory.bot.ServerBot;
import com.egorius.rawstory.entitys.Post;
import com.egorius.rawstory.repos.BlogRepo;

@Service
public class BlogServiceImpl implements BlogService{

    private BlogRepo blogRepo;

    @Autowired
    public BlogServiceImpl(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        blogRepo.findAll().forEach(posts::add);
        return posts;
    }

    @Override
    public List<Post> getPostByName(String name) {
        return blogRepo.findAllByName(name);
    }

    @Override
    public Post addNewPost(Post post) {
        String[] imgPaths = post.getPaths();
        String[] img = Utils.transformImg(imgPaths);
        post.setPaths(img);
        return blogRepo.save(post);
    }
}
