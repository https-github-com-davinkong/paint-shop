package com.greenteam.paintshop.dtos;

import com.greenteam.paintshop.entities.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto implements Serializable {
    private Long id;
    private String name;


    public ProductsDto(Products products){
        if (products.getId() != null){
            this.id = products.getId();
        }
        if (products.getName() != null){
            this.name = products.getName();
        }
    }
}
