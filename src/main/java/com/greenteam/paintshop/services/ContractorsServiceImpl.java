package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.ContractorsDto;
import com.greenteam.paintshop.entities.Contractors;
import com.greenteam.paintshop.repositories.ContractorsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.swing.JOptionPane.showMessageDialog;

@Service
public class ContractorsServiceImpl implements ContractorsService {

    @Autowired
    private ContractorsRepository contractorsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public List<String> addContractors(ContractorsDto contractorsDto){
        List<String> response = new ArrayList<>();
        Contractors contractors = new Contractors(contractorsDto);
//        contractors.setIsAdmin(false);
        if (contractors.getEmail().contains("admin")){
            contractors.setIsAdmin(true);
        }else {
            contractors.setIsAdmin(false);
        }
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
                    response.add("http://localhost:8080/html/Contractors/contractorPage.html");
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

}
