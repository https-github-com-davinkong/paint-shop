package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.ClientsDto;
import com.greenteam.paintshop.dtos.ContractorsDto;
import com.greenteam.paintshop.dtos.JobsDto;
import com.greenteam.paintshop.dtos.ProductsDto;
import com.greenteam.paintshop.entities.Clients;
import com.greenteam.paintshop.entities.Contractors;
import com.greenteam.paintshop.entities.Jobs;
import com.greenteam.paintshop.entities.Products;
import com.greenteam.paintshop.repositories.ClientsRepository;
import com.greenteam.paintshop.repositories.ContractorsRepository;
import com.greenteam.paintshop.repositories.JobsRepository;
import com.greenteam.paintshop.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobsServiceImpl implements JobsService{

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private ContractorsRepository contractorsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    @Transactional
    public void addJob(JobsDto jobsDto) {
        Jobs job = new Jobs(jobsDto);
        Optional<Clients> clientsOptional = clientsRepository.findById(jobsDto.getClientDto().getId());
        clientsOptional.ifPresent(job::setClient);

        Optional<Contractors> contractorsOptional = contractorsRepository.findById(jobsDto.getContractorsDto().getId());
        contractorsOptional.ifPresent(job::setContractors);

        Optional<Products> productsOptional = productsRepository.findById(jobsDto.getProductsDto().getId());
        productsOptional.ifPresent(job::setProducts);

        Contractors contractor = contractorsOptional.get();
        jobsRepository.saveAndFlush(job);
        contractor.setJobAssigned(true);
        contractorsRepository.saveAndFlush(contractor);

        System.out.println(jobsDto.getContractorsDto());
        System.out.println("Job added successfully");
    }


    @Transactional
    @Override
    public void deleteJobById(Long jobId) {
        var job = jobsRepository.findById(jobId);
        Long clientId = getJobById(jobId).get().getClientDto().getId();
        Long productId = getJobById(jobId).get().getProductsDto().getId();
        Long contractorId = getJobById(jobId).get().getContractorsDto().getId();


        Optional<Clients> clientOptional = clientsRepository.findById(clientId);
        Optional<Products> productsOptional = productsRepository.findById(productId);
        Optional<Contractors> contractorsOptional = contractorsRepository.findById(contractorId);

        clientOptional.get().setJobsSet(null);
        productsOptional.get().setJobs(null);
        contractorsOptional.get().setJobAssigned(false);
        contractorsOptional.get().setJobs(null);

        clientsRepository.saveAndFlush(clientOptional.get());
        productsRepository.saveAndFlush(productsOptional.get());
        contractorsRepository.saveAndFlush(contractorsOptional.get());
        jobsRepository.delete(job.get());



    }

    @Transactional
    @Override
    public void updateJob(JobsDto jobsDto) {
        Optional<Jobs> jobsOptional = jobsRepository.findById(jobsDto.getId());
        jobsOptional.ifPresent(job -> {
            job.setJobTitle(jobsDto.getJobTitle());
//            job.setClient(jobsDto.getClientDto());
//            job.setContractors(jobsDto.getContractors());
            job.setDate(jobsDto.getDate());
//            job.setProducts(jobsDto.getProducts());
            jobsRepository.saveAndFlush(job);});
    }

    @Override
    public List<JobsDto> getAllJobs() {
        List<Jobs> jobsList = jobsRepository.findAll();
        return jobsList.stream().map(JobsDto::new).collect(Collectors.toList());
    }

    @Override
    public Optional<JobsDto> getJobById(Long jobId) {
        Optional<Jobs> jobsOptional = jobsRepository.findById(jobId);
        return jobsOptional.map(JobsDto::new);
    }
}
