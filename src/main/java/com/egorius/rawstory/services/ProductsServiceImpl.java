package com.egorius.rawstory.services;

import java.util.ArrayList;
import java.util.List;

import com.egorius.rawstory.bot.ServerBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egorius.rawstory.entitys.Product;
import com.egorius.rawstory.repos.ProductsRepo;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepo productsRepo;

    @Autowired
    public ProductsServiceImpl(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }


    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productsRepo.findAll().forEach(products::add);
        return products;
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productsRepo.findAllByName(name);
    }

    @Override
    public Product addNewProduct(Product product) {
        String[] imgPaths = product.getPaths();
        String[] img = Utils.transformImg(imgPaths);
        product.setPaths(img);
        return productsRepo.save(product);
    }
}
