package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.ContractorsDto;
import com.greenteam.paintshop.dtos.JobsDto;
import com.greenteam.paintshop.entities.Clients;
import com.greenteam.paintshop.entities.Contractors;
import com.greenteam.paintshop.entities.Jobs;
import com.greenteam.paintshop.repositories.ClientsRepository;
import com.greenteam.paintshop.repositories.ContractorsRepository;
import com.greenteam.paintshop.repositories.JobsRepository;
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

    @Override
    @Transactional
    public void addJob(JobsDto jobsDto) {
        Jobs job = new Jobs(jobsDto);
        System.out.println(job.getContractors());
        Optional<Clients> clientsOptional = clientsRepository.findById(jobsDto.getClientDto().getId());
        clientsOptional.ifPresent(job::setClient);

        Optional<Contractors> contractorsOptional = contractorsRepository.findById(jobsDto.getContractorsDto().getId());
        contractorsOptional.ifPresent(job::setContractors);

//        if (job.getContractors() == null) {
//            job.setContractors(new HashSet<>());
//        }
//        for (ContractorsDto contractorDto : jobsDto.getContractorsDto()) {
//            Optional<Contractors> contractorOptional = contractorsRepository.findById(contractorDto.getId());
//            if(contractorOptional.isPresent()) {
//                var contractor = job.getContractors();
//                contractor.add(contractorOptional.get());
////                contractorOptional.get().setJobs(job);
//                job.setContractors(contractor);
//
//            }
//        }
        jobsRepository.saveAndFlush(job);

//        for (ContractorsDto contractorDto : jobsDto.getContractorsDto()) {
//            Optional<Contractors> contractorOptional = contractorsRepository.findById(contractorDto.getId());
//            if(contractorOptional.isPresent()) {
//                contractorOptional.get().setJobs(job);
//                contractorsRepository.saveAndFlush(contractorOptional.get());
//            }
//        }

        System.out.println(jobsDto.getContractorsDto());
        System.out.println("Job added successfully");
    }


    @Transactional
    @Override
    public void deleteJobById(Long jobId) {
        Optional<Jobs> jobsOptional = jobsRepository.findById(jobId);
        jobsOptional.ifPresent(job -> jobsRepository.delete(job));
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
