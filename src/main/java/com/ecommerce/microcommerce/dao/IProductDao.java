package com.ecommerce.microcommerce.dao;

import java.util.List;

import com.ecommerce.microcommerce.model.product.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer> {

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

    /**
     * Return list with a price greater of parameter in function
     * @param limitPrice limite price
     * @return List of product
     */
    public List<Product> findByPriceGreaterThan(int limitPrice);

    /**
     * Native SQL Query
     * @param limitPrice
     * @return
     */
    @Query(value = "SELECT p.id, p.name, p.price, p.buy_price, p.provider FROM product p WHERE p.price < :limitPrice", nativeQuery = true)
    List<Product> findByPriceInferiorThan(@Param("limitPrice") int limitPrice);

    /**
     * HQL query
     * @param price
     * @return
     */
    @Query(value = "SELECT p FROM Product p WHERE p.price = :price")
    Product findByPriceThan(@Param(value = "price") int price);
}