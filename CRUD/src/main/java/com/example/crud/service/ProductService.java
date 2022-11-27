package com.example.crud.service;

import com.example.crud.model.Product;

import java.util.ArrayList;

public class ProductService {
    private static final ArrayList<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product("1","a",10000));
        products.add(new Product("2","b",20000));
        products.add(new Product("3","c",30000));
        products.add(new Product("4","d",40000));
    }

    public ArrayList<Product> getProductsList() {
        return products;
    }

    public Product getProduct(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void createProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public void updateProduct(int index, Product product) {
        products.set(index, product);
    }

    public ArrayList<Product> display() {
        return products;
    }
}
