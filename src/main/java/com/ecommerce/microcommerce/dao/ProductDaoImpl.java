package com.ecommerce.microcommerce.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.ecommerce.microcommerce.model.product.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements IProductDao {

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Ordinateur Portable", 750));
        products.add(new Product(2, "Nintendo Switch", 350));
        products.add(new Product(3, "Ecran PC Gamer BenQ", 200));
    }

    @Override
    public List<Product> findAll() {
        Stream<Product> stream = products.stream();
        stream.filter(x -> x.getPrice() > 400).forEach(System.out::println);
        return products;
    }

    @Override
    public Product findById(int id) {
        Stream<Product> stream = products.stream();
        Product product = stream.filter(x -> x.getId() == id).findFirst().orElse(new Product());
        return product;
    }

    @Override
    public Product save(Product product) {
        Stream<Product> stream = products.stream();
        Product productInsert = stream.filter(x -> x.getId() != product.getId()).findFirst().orElse(null);
        return productInsert;
    }

    @Override
    public void displayProductInConsole() {
        Stream<Product> stream = products.stream();
        stream.forEach(System.out::println);
    }

    @Override
    public List<Product> getListProducts() {
        return products;
    }
}