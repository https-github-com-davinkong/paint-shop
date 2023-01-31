package com.greenteam.paintshop.controllers;

import com.greenteam.paintshop.dtos.ContractorsDto;
import com.greenteam.paintshop.services.ContractorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{contractorId}")
    public Optional<ContractorsDto> getContractorsById(@PathVariable Long contractorId){
        return contractorsService.getContractorsById(contractorId);
    }

    @GetMapping("/allContractors")
    public List<ContractorsDto> getAllContractors(){
        return contractorsService.getAllContractors();
    }
    @DeleteMapping("/{contractorId}")
    public void deleteContractorsById(@PathVariable Long contractorId){
        contractorsService.deleteContractorsById(contractorId);
    }
}
