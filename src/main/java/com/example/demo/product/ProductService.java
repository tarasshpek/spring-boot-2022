package com.example.demo.product;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        Product one = new Product();
        one.setName("Mars");
        one.setPrice(BigDecimal.valueOf(15));
        products.add(one);
        Product two = new Product();
        two.setName("Snickers");
        two.setPrice(BigDecimal.valueOf(20));
        products.add(two);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void create(Product product) {
        products.add(product);
    }

}
