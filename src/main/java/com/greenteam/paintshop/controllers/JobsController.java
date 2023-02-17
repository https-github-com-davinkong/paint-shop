package com.greenteam.paintshop.controllers;

import com.greenteam.paintshop.dtos.JobsDto;
import com.greenteam.paintshop.entities.Contractors;
import com.greenteam.paintshop.entities.Jobs;
import com.greenteam.paintshop.repositories.ContractorsRepository;
import com.greenteam.paintshop.services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/jobs")
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @Autowired
    private ContractorsRepository contractorsRepository;

    @PostMapping("/job")
    public ResponseEntity<List<String>> addJob(@RequestBody JobsDto jobsDto) {
        System.out.println(jobsDto);
        List<String> response = new ArrayList<>();
        jobsService.addJob(jobsDto);
        response.add("Job added successfully");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Optional<JobsDto>> getJobById(@PathVariable Long jobId) {
        return ResponseEntity.ok().body(jobsService.getJobById(jobId));
    }

    @GetMapping("/all-jobs")
    public ResponseEntity<List<JobsDto>> getAllJobs() {
        return ResponseEntity.ok().body(jobsService.getAllJobs());
    }

    @DeleteMapping("/{jobId}")
    public void deleteJobById(@PathVariable Long jobId) {
        System.out.println("deleteJobById method reached");
        Optional<JobsDto> job = jobsService.getJobById(jobId);
        Optional<Contractors> contractorsOptional = contractorsRepository.findById(job.get().getContractorsDto().getId());
        Contractors contractor = contractorsOptional.get();
        contractor.setJobAssigned(false);
        contractorsRepository.saveAndFlush(contractor);
        jobsService.deleteJobById(jobId);
    }
}
