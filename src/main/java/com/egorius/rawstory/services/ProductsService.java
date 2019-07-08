package com.egorius.rawstory.services;

import java.util.List;

import com.egorius.rawstory.entitys.Product;

public interface ProductsService {
    List<Product> getAllProducts();

    List<Product> getProductByName(String name);

    Product addNewProduct(Product product);

}
