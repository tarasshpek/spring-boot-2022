package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private ProductProperties properties;


    @ResponseBody
    @GetMapping("/products")
    public List<Product> product() {
        return service.getProducts().stream()
                .peek(p -> p.setPrice(p.getPrice().add(properties.getTax())))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @PostMapping("/products")
    public void create(@RequestBody Product product) {
        throw new IllegalArgumentException();
    }

}
