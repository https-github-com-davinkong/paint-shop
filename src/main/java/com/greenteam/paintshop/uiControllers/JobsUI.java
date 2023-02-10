package com.greenteam.paintshop.uiControllers;

import com.greenteam.paintshop.entities.Clients;
import com.greenteam.paintshop.entities.Contractors;
import com.greenteam.paintshop.entities.Jobs;
import com.greenteam.paintshop.repositories.ClientsRepository;
import com.greenteam.paintshop.repositories.ContractorsRepository;
import com.greenteam.paintshop.repositories.JobsRepository;
import com.greenteam.paintshop.repositories.ProductsRepository;
import com.greenteam.paintshop.services.ClientsService;
import com.greenteam.paintshop.services.ContractorsService;
import com.greenteam.paintshop.services.JobsService;
import com.greenteam.paintshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobsUI {

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private ContractorsService contractorsService;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/jobs/new")
    public String showForm(Model model) {
//        model.addAttribute("client", new Clients());
        model.addAttribute("clients", clientsRepository.findAll());
        model.addAttribute("products", productsRepository.findAll());
        model.addAttribute("contractors", contractorsService.getAllContractorsWithoutAJob());
        model.addAttribute("job", new Jobs());
        return "jobs";
    }
}
