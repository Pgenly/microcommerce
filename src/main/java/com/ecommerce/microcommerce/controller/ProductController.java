package com.ecommerce.microcommerce.controller;

import java.net.URI;
import java.util.List;

import com.ecommerce.microcommerce.dao.IProductDao;
import com.ecommerce.microcommerce.model.product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductController {

    @Autowired
    IProductDao iProductDao;

    @GetMapping(value = "/produits")
    public List<Product> findAll() {
        return iProductDao.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable int id) {
        return iProductDao.findById(id);
    }

    @PostMapping(value = "/produit")
    public ResponseEntity<Void> save(@RequestBody Product product) {
        Product newProduct = iProductDao.save(product);
        return createdResponseEntity(newProduct);
    }

    /**
     * Build a response Entity according to value of parameters "newProduct"
     * @param newProduct is a product on which we build a the answer
     * @return response a response entity code ("201 Created" Or "204 No Content")
     */
    public ResponseEntity<Void> createdResponseEntity(Product newProduct) {
        // Return response when the object is null "Error 204 Not Content"
        if(newProduct == null) {
            return ResponseEntity.noContent().build();
        } 

        // Construct a response "201 created" if the object is not null
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()                   // Get a current request (http:localhost:8080)
            .path("/{id}")                          // The id of a new object created
            .buildAndExpand(newProduct.getId())     // Assign a value to parameter on the previous line
            .toUri();                               // Convert to URI with parameter define on the previous lines for the header response
        
        // Return response "201 created"
        return ResponseEntity.created(location).build();
    }
}