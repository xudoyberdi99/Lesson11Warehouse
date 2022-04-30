package com.company.warehouse.controller;

import com.company.warehouse.entity.Product;
import com.company.warehouse.payload.ProductDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto){
        Result result = productService.addProduct(productDto);
        return result;
    }
    @GetMapping
    public List<Product> getAllproduct(){
        List<Product> allProduct = productService.getAllProduct();
        return allProduct;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        Product product = productService.getProduct(id);
        return product;
    }
    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable Integer id){
        Result result = productService.deleteProduct(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editProduct(@PathVariable Integer id, @RequestBody ProductDto productDto){
        Result result = productService.editProduct(id, productDto);
        return result;
    }
}
