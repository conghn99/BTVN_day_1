package com.example.btvn_day_1.service;

import com.example.btvn_day_1.model.Job;
import com.example.btvn_day_1.request.UpsertJobRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JobService {
    private List<Job> jobs;

    public JobService() {
        jobs = new ArrayList<>();
        jobs.add(new Job("1", "Title1", "Desc1", "locate1", 10, 50, "ti1@gmail.com"));
        jobs.add(new Job("2", "Title2", "Desc2", "locate2", 20, 60, "ti2@gmail.com"));
        jobs.add(new Job("3", "Title3", "Desc3", "locate3", 30, 70, "ti3@gmail.com"));
        jobs.add(new Job("4", "Title4", "Desc4", "locate4", 40, 80, "ti4@gmail.com"));
    }

    public List<Job> getJobs() {

        return jobs;
    }

    public Job getJobById(String id) {

        return jobs.stream().filter(s -> id.equals(s.getId())).findAny().orElse(null);
    }

    public Job createJob(UpsertJobRequest request) {
        Random rd = new Random();
        String id = Integer.toString(rd.nextInt(100));

        Job job = new Job(id, request.getTitle(), request.getDescription(), request.getLocation(), request.getMinSalary(), request.getMaxSalary(), request.getEmailTo());
        jobs.add(job);
        return job;
    }

    public Job updateJob(String id, UpsertJobRequest request) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(request.getTitle());
                job.setDescription((request.getDescription()));
                job.setLocation(request.getLocation());
                job.setMinSalary(request.getMinSalary());
                job.setMaxSalary(request.getMaxSalary());
                job.setEmailTo(request.getEmailTo());
                return job;
            }
        }
        return null;
    }

    public void deleteJob(String id) {
        jobs.removeIf(job -> job.getId().equals(id));
    }

    public Job getRandomJob() {
        Random rd = new Random();
        return jobs.get(rd.nextInt(jobs.size()));
    }

    public List<Job> descendingMaxSalary() {
        List<Job> desJob = new ArrayList<>(jobs);
        desJob.sort((o1, o2) -> o2.getMaxSalary() - o1.getMaxSalary());
        return desJob;
    }
}
