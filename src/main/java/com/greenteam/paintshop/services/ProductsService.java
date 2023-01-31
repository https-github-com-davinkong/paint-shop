package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.ProductsDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    //Adding a product
    @Transactional
    void addProduct(ProductsDto productsDto, Long jobId);

    //Deleting a product
    @Transactional
    void deleteProductById(Long productId);

    //Updating a Product
    void updateProductById(ProductsDto productsDto);

    //Finding all products
    List<ProductsDto> getAllProductsByJobId(Long jobId);



    //Getting a product by the product id
    Optional<ProductsDto> getProductById(Long productId);
}
