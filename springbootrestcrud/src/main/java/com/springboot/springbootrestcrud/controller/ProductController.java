package com.springboot.springbootrestcrud.controller;

import com.springboot.springbootrestcrud.model.Product;
import com.springboot.springbootrestcrud.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product/")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("saveProduct")
    public Product saveProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("saveProducts")
    public List<Product> saveProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("getProducts")
    public List<Product> getProduct(){
       return service.getProduct();
    }
    @GetMapping("getProduct/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("getProductByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @DeleteMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return "Delete this product id no "+ id;
    }

    @PutMapping("updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }



}
