package com.example.btvn_day_1.controller;

import com.example.btvn_day_1.model.Job;
import com.example.btvn_day_1.request.UpsertJobRequest;
import com.example.btvn_day_1.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    public List<Job> getJobs() {

        return jobService.getJobs();
    }

    @GetMapping("jobs/{id}")
    public Job getJobById(@PathVariable String id) {

        return jobService.getJobById(id);
    }

    @PostMapping("jobs")
    public Job createJob(@RequestBody UpsertJobRequest request) {

        return jobService.createJob(request);
    }

    @PutMapping("jobs/{id}")
    public Job updateJob(@PathVariable String id, @RequestBody UpsertJobRequest request) {
        return jobService.updateJob(id, request);
    }

    @DeleteMapping("jobs/{id}")
    public void deleteJob(@PathVariable String id) {

        jobService.deleteJob(id);
    }

    @GetMapping("jobs/random")
    public Job getRandomJob() {

        return jobService.getRandomJob();
    }

    @GetMapping("sort")
    public List<Job> descendingMaxSalary(@RequestParam String max_salary) {
        if (max_salary.equals("desc")) {
            return jobService.descendingMaxSalary();
        }
        return null;
    }
}
