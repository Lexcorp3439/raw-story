package com.egorius.rawstory.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.egorius.rawstory.entitys.Product;

@Repository
public interface ProductsRepo extends CrudRepository<Product, Long> {
    List<Product> findAllByName(String name);
}
