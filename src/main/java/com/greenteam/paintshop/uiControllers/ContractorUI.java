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

    //Home page of contractors
    @GetMapping("/contractorPage/{contractorId}")
    public String contractorPage(@PathVariable Long contractorId, Model model){
        model.addAttribute("jobsById", contractorsService.getJobsByContractorId(contractorId));
        model.addAttribute("contractorById", contractorsService.getContractorsById(contractorId));
        return "contractorPage";
    }

    //Get a contractor by id
    @GetMapping("getContractor/{contractorId}")
    public String contractorById(@PathVariable Long contractorId, Model model){
        model.addAttribute("contractorById", contractorsService.getContractorsById(contractorId));
        return "contractorPage";
    }

}
