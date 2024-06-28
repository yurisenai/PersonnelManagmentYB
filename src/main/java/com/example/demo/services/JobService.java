package com.example.demo.services;

import com.example.demo.models.Job;
import com.example.demo.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Optional<Job> findById(int id) {
        return jobRepository.findById(id);
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public void deleteById(int id) {
        jobRepository.deleteById(id);
    }
}
