package com.elementall.eps.backend.crewplanner.devUtils;

import com.elementall.eps.backend.crewplanner.models.Employee;
import com.elementall.eps.backend.crewplanner.models.Job;
import com.elementall.eps.backend.crewplanner.models.JobStatus;
import com.elementall.eps.backend.crewplanner.repositories.EmployeeRepository;
import com.elementall.eps.backend.crewplanner.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestDataFiller implements CommandLineRunner {


    @Autowired private JobRepository jobRepo;
    @Autowired private EmployeeRepository employeeRepo;

    @Override
    public void run(String... args) throws Exception {
        // Create test Employees
        Employee etest1 = new Employee();
        etest1.setName("Bas", "Brunink");
        employeeRepo.save(etest1);

        Employee etest2 = new Employee();
        etest2.setName("Roy", "Brunink");
        employeeRepo.save(etest2);


        Job jpending1 = new Job();
        jpending1.setStatus(JobStatus.PENDING);
        jpending1.setName("Pending test licht");
        jpending1.setDescription("Bouw licht op locatie");
        jpending1.setCreationDate(LocalDate.now());
        jpending1.addEmployee(etest1);
        jpending1.addEmployee(etest2);
        jobRepo.save(jpending1);


        Job jpending2 = new Job();
        jpending2.setStatus(JobStatus.PENDING);
        jpending2.setName("Pending test geluid");
        jpending2.setDescription("Bouw geluid op locatie");
        jpending2.setCreationDate(LocalDate.now());
        jobRepo.save(jpending2);

        Job jpending3 = new Job();
        jpending3.setStatus(JobStatus.PENDING);
        jpending3.setName("Pending test rigging");
        jpending3.setDescription("Bouw rigging op locatie");
        jpending3.setCreationDate(LocalDate.now());
        jobRepo.save(jpending3);

        Job jplanned1 = new Job();
        jplanned1.setStatus(JobStatus.PLANNED);
        jplanned1.setName("Done test geluid");
        jplanned1.setDescription("Bouw geluid op locatie");
        jplanned1.setCreationDate(LocalDate.now());
        jobRepo.save(jplanned1);

        Job jdone1 = new Job();
        jdone1.setStatus(JobStatus.DONE);
        jdone1.setName("Done test licht");
        jdone1.setDescription("Bouw licht op locatie");
        jdone1.setCreationDate(LocalDate.now());
        jobRepo.save(jdone1);

        Job jinvoice1 = new Job();
        jinvoice1.setStatus(JobStatus.INVOICE);
        jinvoice1.setName("Done test licht");
        jinvoice1.setDescription("Bouw licht op locatie");
        jinvoice1.setCreationDate(LocalDate.now());
        jobRepo.save(jinvoice1);

        Job jcomplete1 = new Job();
        jcomplete1.setStatus(JobStatus.COMPLETED);
        jcomplete1.setName("Done test licht");
        jcomplete1.setDescription("Bouw licht op locatie");
        jcomplete1.setCreationDate(LocalDate.now());
        jobRepo.save(jcomplete1);





    }
}
