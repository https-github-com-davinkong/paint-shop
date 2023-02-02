package com.greenteam.paintshop.uiControllers;

import com.greenteam.paintshop.services.ClientsService;
import com.greenteam.paintshop.services.ContractorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClientsUI {
    @Autowired
    private ClientsService clientsService;

    //Home page of contractors
    @GetMapping("/clients")
    public String clientsPage( Model model){
        return "clients";
    }

}
