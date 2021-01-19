package com.elementall.eps.backend.crewplanner.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Employee extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate employedDate;
    private LocalDate terminationDate;

    @ManyToMany
    private List<Job> plannedJobs;


    public Employee() {
        this.plannedJobs = new ArrayList<>();
    }

    public void setName(String first, String last) {
        super.setFirstName(first);
        super.setLastName(last);
    }

    public void addJob(Job job) {
        this.plannedJobs.add(job);
    }
}

