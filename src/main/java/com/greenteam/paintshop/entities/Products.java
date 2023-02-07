package com.greenteam.paintshop.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.greenteam.paintshop.dtos.ProductsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String paintColor;

    @Column
    private String description;

    @Column
    private String tools;



    public Products(ProductsDto productsDto){
        if (productsDto.getPaintColor()!= null){
            this.paintColor = productsDto.getPaintColor();
        }
        if (productsDto.getDescription()!= null){
            this.description = productsDto.getDescription();
        }
        if (productsDto.getTools()!= null){
            this.tools = productsDto.getTools();
        }
    }
    @OneToOne(mappedBy = "products", cascade = CascadeType.ALL)
    @JsonBackReference
    private Jobs jobs;
}
