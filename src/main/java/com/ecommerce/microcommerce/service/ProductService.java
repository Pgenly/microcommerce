package com.ecommerce.microcommerce.service;

import java.util.List;

import com.ecommerce.microcommerce.dao.IProductDao;
import com.ecommerce.microcommerce.model.product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    IProductDao iProductDao;

    public List<Product> findAll() {
        return iProductDao.findAll();
    }

    public Product findById(int id) {
        return iProductDao.findById(id);
    }

    public Product save(Product product) {
        return iProductDao.save(product);
    }
}