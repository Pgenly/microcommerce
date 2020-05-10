package com.ecommerce.microcommerce.dao;

import java.util.List;

import com.ecommerce.microcommerce.model.product.Product;

public interface IProductDao {

    /**
     * display all product
     * @return list of product
     */
    public List<Product> findAll();

    /**
     * Search a product with your id
     * @param id
     * @return Product object
     */
    public Product findById(int id);

    /**
     * Add product in database
     * @param product product adding in database
     * @return Product for check if the product is added in database
     */
    public Product save(Product product);
}