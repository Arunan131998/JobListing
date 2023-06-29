package com.arunan.joblisting.repository;

import com.arunan.joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost,String> {
}
