package com.greenteam.paintshop.uiControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopOwnerUI {
    @GetMapping("/shopOwner")
    public String getJobs(Model model){
        return "shopOwner";
    }
}
