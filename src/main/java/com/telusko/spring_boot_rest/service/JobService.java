package com.telusko.spring_boot_rest.service;


import com.telusko.spring_boot_rest.model.JobPost;
import com.telusko.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
        new JobPost(1, "Java Developer", "Must have good experience in core java", 2, Arrays.asList("Java", "PostgreSQL", "Spring")),
        new JobPost(2, "Frontend Developer", "Experience in building responsive websites", 1, Arrays.asList("Java", "PostgreSQL", "Spring")),
        new JobPost(3, "Data Scientist", "Strong bsckground in machine learning", 4, Arrays.asList("Java", "PostgreSQL", "Spring")),
        new JobPost(4, "Network Engineer", "Design and implement computer network", 3, Arrays.asList("Java", "PostgreSQL", "Spring")),
        new JobPost(5, "Mobile App Developer", "Experience in mobile app development", 0, Arrays.asList("Java", "PostgreSQL", "Spring"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }


}
