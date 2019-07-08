package com.egorius.rawstory.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egorius.rawstory.entitys.Product;
import com.egorius.rawstory.services.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductsService service;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.service = productsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }
}
