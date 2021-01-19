package com.elementall.eps.backend.crewplanner.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Entity
public class JobPlannedEmpoyees {
    @Id
    private long Id;

    @ManyToOne
    @JoinColumn(name="job_id")
    Job job;
    @ManyToOne
    @JoinColumn(name="employee_id")
    Employee employee;



}
