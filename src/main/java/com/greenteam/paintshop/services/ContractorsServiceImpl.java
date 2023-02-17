package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.ContractorsDto;
import com.greenteam.paintshop.dtos.JobsDto;
import com.greenteam.paintshop.entities.Contractors;
import com.greenteam.paintshop.entities.Jobs;
import com.greenteam.paintshop.repositories.ContractorsRepository;
import com.greenteam.paintshop.repositories.JobsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static javax.swing.JOptionPane.showMessageDialog;

@Service
public class ContractorsServiceImpl implements ContractorsService {

    @Autowired
    private ContractorsRepository contractorsRepository;
    @Autowired
    private JobsRepository jobsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public List<String> addContractors(ContractorsDto contractorsDto){
        List<String> response = new ArrayList<>();
        Contractors contractors = new Contractors(contractorsDto);

        if (contractors.getEmail().contains("admin")){
            contractors.setIsAdmin(true);
        }else {
            contractors.setIsAdmin(false);
        }
        contractors.setJobAssigned(false);
        contractorsRepository.saveAndFlush(contractors);
        response.add("http://localhost:8080/html/RegisterLogin/login.html");
        return response;
    }

    @Override
    public List<String> login(ContractorsDto contractorsDto){
        List<String> response = new ArrayList<>();
        Optional<Contractors> contractorsOptional = contractorsRepository.findByEmail(contractorsDto.getEmail());

        if (contractorsOptional.isPresent()){
            if (passwordEncoder.matches(contractorsDto.getPassword(), contractorsOptional.get().getPassword())){

                if (contractorsOptional.get().getIsAdmin().equals(true)){
                    response.add("http://localhost:8080/shopOwner");
                    response.add(String.valueOf(contractorsOptional.get().getId()));

                }else {
                    response.add("http://localhost:8080/contractorPage/"+ contractorsOptional.get().getId());
                    response.add(String.valueOf(contractorsOptional.get().getId()));
                }

            }else {
                response.add("Username or Password is incorrect");
                response.add("http://localhost:8080/html/RegisterLogin/login.html");
                showMessageDialog(null, "Username or Password is incorrect");
            }
        }else {
            response.add("Username or Password is incorrect");
            response.add("http://localhost:8080/html/RegisterLogin/login.html");
            showMessageDialog(null, "Username or Password is incorrect");
        }
        return response;
    }

    @Override
    public List<ContractorsDto> getContractorsById(Long contractorId){
        Optional<Contractors> contractorsOptional = contractorsRepository.findById(contractorId);
        if (contractorsOptional.isPresent()){
            return contractorsOptional.stream().map(contractors -> new ContractorsDto(contractors)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<JobsDto> getJobsByContractorId(Long contractorId){
        Optional<Contractors> contractorsJob = contractorsRepository.findById(contractorId);
        if (contractorsJob.isPresent()){
            List<Jobs> jobsList = jobsRepository.findAllByContractorsEquals(contractorsJob.get());
            return jobsList.stream().map(jobs -> new JobsDto(jobs)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> getRoleById(Long contractorId){
        List<String> response = new ArrayList<>();
        Optional<Contractors> contractorsOptional = contractorsRepository.findById(contractorId);
        if (contractorsOptional.isPresent()){
            response.add(String.valueOf(contractorsOptional.get().getIsAdmin()));
        }
        return response;
    }
    @Override
    public List<ContractorsDto> getAllContractors(){
        List<Contractors> contractorsOptional = contractorsRepository.findAll();
        return contractorsOptional.stream().map(contractors -> new ContractorsDto(contractors)).collect(Collectors.toList());
    }

    @Override
    public List<ContractorsDto> getAllContractorsWithoutAJob() {
        List<Contractors> contractorsOptional = contractorsRepository.findAll();
        return contractorsOptional.stream().map(ContractorsDto::new).filter(contractors -> !contractors.getJobAssigned()).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteContractorsById(Long contractorId){
        Contractors contractors = contractorsRepository.getById(contractorId);
        if (contractors == null){
            throw new RuntimeException("Not found");
        }
        contractorsRepository.deleteById(contractorId);
    }


}
