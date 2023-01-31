package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.JobsDto;
import com.greenteam.paintshop.entities.Jobs;
import com.greenteam.paintshop.repositories.JobsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobsServiceImpl implements JobsService{

    @Autowired
    private JobsRepository jobsRepository;

    @Override
    @Transactional
    public void addJob(JobsDto jobsDto) {
        Jobs job = new Jobs(jobsDto);
        jobsRepository.saveAndFlush(job);
        System.out.println("Job added successfully");
    }

    @Override
    public void deleteJobById(Long jobId) {
        Optional<Jobs> jobsOptional = jobsRepository.findById(jobId);
        jobsOptional.ifPresent(job -> jobsRepository.delete(job));
    }

    @Override
    public void updateJob(JobsDto jobsDto) {
        Optional<Jobs> jobsOptional = jobsRepository.findById(jobsDto.getId());
        jobsOptional.ifPresent(job -> {
            job.setJobTitle(jobsDto.getJobTitle());
            job.setClient(jobsDto.getClient());
            job.setContractors(jobsDto.getContractors());
            job.setDate(jobsDto.getDate());
            job.setProducts(jobsDto.getProducts());
        });

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
