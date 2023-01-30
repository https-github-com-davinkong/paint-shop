package com.greenteam.paintshop.services;


import com.greenteam.paintshop.dtos.ProductsDto;
import com.greenteam.paintshop.entities.Products;
import com.greenteam.paintshop.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private JobsRepository jobsRepository;
   @Autowired
    private ProductsRepository productsRepository;


   //Adding a product
   @Override
   @Transactional
    public void addProduct(ProductsDto productsDto, Long jobId) {
       Optional<Job> jobOptional = jobsRepository.findById(jobId);
       Products products = new Products(productsDto);
       jobOptional.ifPresent(products::setJob);
       productsRepository.saveAndFlush(products);
   }

   //Deleting a product
    @Override
    @Transactional
    public void deleteProductById(Long productId) {
       Optional<Products> productsOptional = productsRepository.findById(productId);
       productsOptional.ifPresent(products -> productsRepository.delete(products));
    }

    //Updating a Product
    @Override
    public void updateProductById(ProductsDto productsDto) {
       Optional<Products> productsOptional = productsRepository.findById(productsDto.getId());
       productsOptional.ifPresent(products -> {products.setName(productsDto.getName());
       productsRepository.saveAndFlush(products);
       });
    }

    //Finding all products
    @Override
    public List<ProductsDto> getAllProductsByJobId(Long jobId){
       Optional<Job> jobOptional = jobsRepository.findById(jobId);
       if (jobOptional.isPresent()){
           List<Products> productsList = productsRepository.findAllByJobEquals(jobOptional.get());
           return productsList.stream().map(products -> new ProductsDto(products)).collect(Collectors.toList());
       }
       return Collections.emptyList();
    }

    //Getting a product by the product id
    @Override
    public Optional<ProductsDto> getProductById(Long productId) {
       Optional<Products> productsOptional = productsRepository.findById(productId);
       if (productsOptional.isPresent()){
           return Optional.of(new ProductsDto(productsOptional.get()));
       }
       return Optional.empty();
    }
}
