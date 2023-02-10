package com.greenteam.paintshop.uiControllers;


import com.greenteam.paintshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ProductsUI {
    @Autowired
    private ProductsService productsService;

    // Product main page
    @GetMapping("/products")
    public String productsPage( Model model){
        model.addAttribute("listAllProducts", productsService.getAllProducts());
        return "products";
    }

    // Delete a product
    @GetMapping("deleteProduct/{productId}")
    public String deleteProductById(@PathVariable Long productId, Model model) {
        productsService.deleteProductById(productId);
        return "redirect:/products";
    }

}








