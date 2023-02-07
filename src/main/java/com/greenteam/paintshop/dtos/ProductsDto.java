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
    private String paintColor;
    private String description;
    private String tools;


    public ProductsDto(Products products){
        if (products.getId() != null){
            this.id = products.getId();
        }
        if (products.getPaintColor() != null){
            this.paintColor = products.getPaintColor();
        }
        if (products.getDescription() != null){
            this.description = products.getDescription();
        }
        if (products.getTools() != null){
            this.tools = products.getTools();
        }
    }
}
