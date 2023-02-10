package com.greenteam.paintshop.controllers;

import com.greenteam.paintshop.dtos.ClientsDto;
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

//    @GetMapping("/jobs/{jobId}")
//    public List<ProductsDto> getProductsByJob(@PathVariable Long jobId){
//        return productsService.getAllProductsByJobId(jobId);
//    }

    //Add a new product
//    @PostMapping("/jobs/{jobId}")
//    public void addProduct(@RequestBody ProductsDto productsDto, @PathVariable Long jobId){
//        productsService.addProduct(productsDto, jobId);
//    }
    @PostMapping("/product")
    public void addProduct(@RequestBody ProductsDto productsDto){
        productsService.addProduct(productsDto);
    }


    @PostMapping("/")
    public void addAProduct(@RequestBody ProductsDto productsDto){
        productsService.addAProduct(productsDto);
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

    // GET all clients
    @GetMapping("/products")
    public List<ProductsDto> getProducts(){
        return productsService.getAllProducts();
    }
}
