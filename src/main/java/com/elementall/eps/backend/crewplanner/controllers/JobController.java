package com.elementall.eps.backend.crewplanner.controllers;

import com.elementall.eps.backend.crewplanner.models.Job;
import com.elementall.eps.backend.crewplanner.services.JobService;
import com.elementall.eps.backend.crewplanner.tools.JsonViews;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/crewplanner/job")
public class JobController {


    @Autowired JobService jobService;

    @PostMapping("/")
    Job newJob(@RequestBody Job newJob)
    {
        return jobService.addJob(newJob);
    }
    @GetMapping("/")
    public MappingJacksonValue getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        MappingJacksonValue mapping = new MappingJacksonValue(jobs);
        mapping.setSerializationView(JsonViews.JobList.class);
        return mapping;
    }

}

