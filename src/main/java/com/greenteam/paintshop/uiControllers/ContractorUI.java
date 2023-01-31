package com.greenteam.paintshop.uiControllers;

import com.greenteam.paintshop.services.ContractorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContractorUI {
    @Autowired
    private ContractorsService contractorsService;


    @GetMapping("/contractorPage")
    public String contractorPage( Model model){

        return "contractorPage";
    }

    @GetMapping("getContractor/{contractorId}")
    public String contractorById(@PathVariable Long contractorId, Model model){
        model.addAttribute("contractorById", contractorsService.getContractorsById(contractorId));

        return "contractorPage";
    }

}
