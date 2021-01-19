package com.elementall.eps.backend.crewplanner.models;

import com.elementall.eps.backend.crewplanner.tools.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonView({JsonViews.JobList.class, JsonViews.AllJob.class})
    private String name;
    @JsonView({JsonViews.JobList.class, JsonViews.AllJob.class})
    private LocalDate creationDate;
    @JsonView({JsonViews.JobList.class, JsonViews.AllJob.class})
    private JobStatus status;
    private String description;
    @JsonView({JsonViews.JobList.class, JsonViews.AllJob.class})
    private LocalDate startDate; //yyyy-MM-dd
    private LocalTime startTime; //HH-mm-ss-ns
    @JsonView({JsonViews.JobList.class, JsonViews.AllJob.class})
    private LocalDate endDate;  //yyyy-MM-dd
    private LocalTime endTime; // HH-mm-ss-ns

    @JsonView(JsonViews.AllJob.class)
    @ManyToMany
    private List<Employee> plannedEmployees;
    @OneToOne
    private Employee ownCrewChief;
    @OneToOne
    private Customer customer;

    public Job() {
        this.plannedEmployees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.plannedEmployees.add(employee);
        employee.addJob(this);
    }
}
