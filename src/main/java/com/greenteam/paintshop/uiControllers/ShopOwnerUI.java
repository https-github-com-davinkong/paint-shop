package com.greenteam.paintshop.uiControllers;

import com.greenteam.paintshop.services.ContractorsService;
import com.greenteam.paintshop.services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopOwnerUI {

    @Autowired
    private ContractorsService contractorsService;
    @Autowired
    private JobsService jobsService;
    //Home page of Shop owner
    @GetMapping("/shopOwner")
    public String shopOwnerPage(Model model){
        model.addAttribute("listAll", jobsService.getAllJobs());
        return "shopOwner";
    }


    //Shop Owner view all Contractors
    @GetMapping("/viewAllContractors")
    public String viewAllContractors(Model model){
        model.addAttribute("listAllContractors", contractorsService.getAllContractors());

        return "viewAllContractors";
    }

    //Shop Owner delete a contractor
    @GetMapping("deleteContractor/{contractorId}")
    public String deleteEmployeeById(@PathVariable Long contractorId, Model model) {
        contractorsService.deleteContractorsById(contractorId);

        //	after delete the contractor from database, redirect to "/viewAllContractors" page
        return "redirect:/viewAllContractors";
    }


}
