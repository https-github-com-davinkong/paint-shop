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

    // Client main page
    @GetMapping("/clients")
    public String clientsPage( Model model){
        model.addAttribute("listAllClients", clientsService.getAllClients());
        return "clients";
    }

    // Delete a client
//    @GetMapping("deleteContractor/{contractorId}")
//    public String deleteEmployeeById(@PathVariable Long contractorId, Model model) {
//        contractorsService.deleteContractorsById(contractorId);
//
//        //	after delete the contractor from database, redirect to "/viewAllContractors" page
//        return "redirect:/viewAllContractors";
//    }

}
