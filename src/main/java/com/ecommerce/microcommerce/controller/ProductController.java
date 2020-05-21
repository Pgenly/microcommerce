package com.ecommerce.microcommerce.controller;

import java.util.List;

import com.ecommerce.microcommerce.model.product.Product;
import com.ecommerce.microcommerce.response.BuildResponseEntity;
import com.ecommerce.microcommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/produits")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping(value = "/produit")
    public ResponseEntity<Void> save(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return BuildResponseEntity.createdResponseEntity(newProduct);
    }

    @GetMapping(value = "/produits/superieur/{limitPrice}")
    public List<Product> findByPriceGreaterThan(@PathVariable int limitPrice) {
        return productService.findByPriceGreaterThan(limitPrice);
    }

    @GetMapping(value = "/produits/inferieur/{limitPrice}")
    public List<Product> findByPriceInferiorThan(@PathVariable int limitPrice) {
        return productService.findByPriceInferiorThan(limitPrice);
    }

    @GetMapping(value = "produit/egal/{price}")
    public Product findByPriceThan(@PathVariable int price) {
        return productService.findByPriceThan(price);
    }
}