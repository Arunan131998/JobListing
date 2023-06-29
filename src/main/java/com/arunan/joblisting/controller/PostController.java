package com.arunan.joblisting.controller;

import com.arunan.joblisting.repository.JobPostRepository;
import com.arunan.joblisting.model.JobPost;
import com.arunan.joblisting.repository.SearchRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class PostController {
    @Autowired
    JobPostRepository repo;
    @Autowired
    SearchRepositoryImpl searchRepo;
    @GetMapping("/allPosts")
    public List<JobPost> getAllJobPosts(){
       return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> searchPosts(@PathVariable String text){
        return searchRepo.searchByText(text);
    }
    @PostMapping("/addPost")
    public JobPost addPost(@RequestBody JobPost jobPost){
        return repo.save(jobPost);
    }
}
