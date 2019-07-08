package com.egorius.rawstory.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.egorius.rawstory.entitys.Post;

@Repository
public interface BlogRepo extends CrudRepository<Post, Long> {
    List<Post> findAllByName(String name);
}
