package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.JobsDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface JobsService {

    @Transactional
    void addJob(JobsDto jobsDto);

    @Transactional
    void deleteJobById(Long jobId);

    @Transactional
    void updateJobById(Long jobId);

    List<JobsDto> getAllJobs();

    Optional<JobsDto> getJobById(Long jobId);

}
