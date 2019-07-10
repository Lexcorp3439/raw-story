package com.egorius.rawstory.services;

import java.util.List;

import com.egorius.rawstory.entitys.Post;

public interface BlogService {
    List<Post> getAllPosts();

    List<Post> getPostByName(String name);

    Post addNewPost(Post post);
}
