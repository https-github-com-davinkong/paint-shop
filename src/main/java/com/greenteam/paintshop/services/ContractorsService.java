package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.ContractorsDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ContractorsService {
    @Transactional
    List<String> addContractors(ContractorsDto contractorsDto);

    List<String> login(ContractorsDto contractorsDto);
}
