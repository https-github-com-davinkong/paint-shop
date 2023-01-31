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
    private String name;



    public Products(ProductsDto productsDto){
        if (productsDto.getName() != null){
            this.name = productsDto.getName();
        }
    }
    @ManyToOne
    @JsonBackReference
    private Jobs jobs;
}
