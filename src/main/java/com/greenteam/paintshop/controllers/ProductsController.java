package com.greenteam.paintshop.controllers;

import com.greenteam.paintshop.dtos.ProductsDto;
import com.greenteam.paintshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/jobs/{jobId}")
    public List<ProductsDto> getProductsByJob(@PathVariable Long jobId){
        return productsService.getAllProductsByJobId(jobId);
    }
    //Add a new product
    @PostMapping("/jobs/{jobId}")
    public void addProduct(@RequestBody ProductsDto productsDto, @PathVariable Long jobId){
        productsService.addProduct(productsDto, jobId);
    }

    //Delete a product
    @DeleteMapping("/{productsId}")
    public void deleteProductById(@PathVariable Long productsId){
        productsService.deleteProductById(productsId);
    }

    //Update an existing Product
    @PutMapping
    public void updateProduct(@RequestBody ProductsDto productsDto){
        productsService.updateProductById(productsDto);
    }

    //Get product by id
    @GetMapping("/{productsId}")
    public Optional<ProductsDto> getProductById(@PathVariable Long productsId){
        return productsService.getProductById(productsId);
    }
}
