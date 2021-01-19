package com.elementall.eps.backend.crewplanner.services;

import com.elementall.eps.backend.crewplanner.models.Job;
import com.elementall.eps.backend.crewplanner.models.JobStatus;
import com.elementall.eps.backend.crewplanner.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {

    @Autowired
    private JobRepository jobRepo;

    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public List<Job> getAllPendingJobs() {
        return jobRepo.findAllByStatus(JobStatus.PENDING);
    }
    public List<Job> getAllPlannedJobs() {
        return jobRepo.findAllByStatus(JobStatus.PLANNED);
    }
    public List<Job> getAllDoneJobs() {
        return jobRepo.findAllByStatus(JobStatus.DONE);
    }
    public List<Job> getAllInvoiceJobs() {
        return jobRepo.findAllByStatus(JobStatus.INVOICE);
    }
    public List<Job> getAllCompletedJobs() {
        return jobRepo.findAllByStatus(JobStatus.COMPLETED);
    }
    public Job getById(long id){
        return jobRepo.findById(id).orElse(null);
    }

    public Job addJob(Job newJob) {

        return jobRepo.save(newJob);
    }
}
