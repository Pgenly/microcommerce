package com.ecommerce.microcommerce.controller;

import java.util.List;

import com.ecommerce.microcommerce.dao.IProductDao;
import com.ecommerce.microcommerce.model.product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Produit")
public class ProductController {

    @Autowired
    IProductDao iProductDao;

    @GetMapping(value = "/all/produits")
    public List<Product> listProduct() {
        return iProductDao.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product displayNewElement(@PathVariable int id) {
        return iProductDao.findById(id);
    }

    @PostMapping(value = "/produit")
    public Product addProduct(@RequestBody Product product) {
        iProductDao.save(product);
        return product;
    }
}