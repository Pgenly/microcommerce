package com.ecommerce.microcommerce.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Product
 */

// Ignore attribute when return JsonObject
@Entity
@JsonIgnoreProperties(value = {"id", "buyPrice", "provider"})
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    private int buyPrice;
    private String provider;

    //Mandatory for POST requests, for parse Object to JSON
    public Product() {
    }

    public Product(int id, String name, int price, int buyPrice, String provider) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.buyPrice = buyPrice;
        this.provider = provider;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBuyPrice() {
        return this.buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
    
}