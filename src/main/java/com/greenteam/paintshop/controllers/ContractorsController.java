package com.greenteam.paintshop.controllers;

import com.greenteam.paintshop.dtos.ContractorsDto;
import com.greenteam.paintshop.dtos.JobsDto;
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

    //Register for both shop owner and contractors
    @PostMapping("/register")
    public List<String> addContractors(@RequestBody ContractorsDto contractorsDto){
        String passHash = passwordEncoder.encode(contractorsDto.getPassword());

        contractorsDto.setPassword(passHash);
        return  contractorsService.addContractors(contractorsDto);
    }

    //Login for both shop owner and contractors
    @PostMapping("/login")
    public List<String> login(@RequestBody ContractorsDto contractorsDto){
        return contractorsService.login(contractorsDto);
    }

    //Get a contractor information by ID
    @GetMapping("/{contractorId}")
    public List<ContractorsDto> getContractorsById(@PathVariable Long contractorId){
        return contractorsService.getContractorsById(contractorId);
    }

    //For contractors to see their jobs, clients, and products. Get it from contractor's id
    @GetMapping("/jobs/{contractorId}")
    public List<JobsDto> getJobsByContractorId(@PathVariable Long contractorId){
        return contractorsService.getJobsByContractorId(contractorId);
    }

    //Get Role to check authorization
    @GetMapping("/checkRole/{contractorId}")
    public List<String> getRoleById(@PathVariable Long contractorId){
        return contractorsService.getRoleById(contractorId);
    }

    //For shop owner to view all contractors
    @GetMapping("/allContractors")
    public List<ContractorsDto> getAllContractors(){
        return contractorsService.getAllContractors();
    }

    //For shop owner to delete a contractor
    @DeleteMapping("/{contractorId}")
    public void deleteContractorsById(@PathVariable Long contractorId){
        contractorsService.deleteContractorsById(contractorId);
    }
}
