package com.greenteam.paintshop.controllers;

import com.greenteam.paintshop.dtos.ContractorsDto;
import com.greenteam.paintshop.services.ContractorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/contractors")
public class ContractorsController {
    @Autowired
    private ContractorsService contractorsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public List<String> addContractors(@RequestBody ContractorsDto contractorsDto){
        String passHash = passwordEncoder.encode(contractorsDto.getPassword());

        contractorsDto.setPassword(passHash);
        return  contractorsService.addContractors(contractorsDto);
    }

    @PostMapping("/login")
    public List<String> login(@RequestBody ContractorsDto contractorsDto){
        return contractorsService.login(contractorsDto);
    }
}
