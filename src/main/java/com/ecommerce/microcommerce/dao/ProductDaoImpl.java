package com.ecommerce.microcommerce.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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
        return products;
    }

    @Override
    public Product findById(int id) {
        Stream<Product> streamProduct = products.stream();
        Product product = streamProduct.filter(x -> x.getId() == id).findFirst().orElse(null);
        return product;
    }

    @Override
    public Product save(Product product) {
        Stream<Product> stream = products.stream();
        boolean hasPresent = stream.anyMatch(x -> x.getId() == product.getId());

        if(!hasPresent) {
            findAll().add(product);
            return product;
        } else {
            return null;
        }
    }
}