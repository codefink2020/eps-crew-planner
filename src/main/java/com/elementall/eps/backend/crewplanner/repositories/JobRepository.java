package com.elementall.eps.backend.crewplanner.repositories;

import com.elementall.eps.backend.crewplanner.models.Job;
import com.elementall.eps.backend.crewplanner.models.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findAllByStatus(JobStatus status);

}
