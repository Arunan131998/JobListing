package com.arunan.joblisting.repository;

import com.arunan.joblisting.model.JobPost;

import java.util.List;

public interface SearchRepository {

    public List<JobPost> searchByText(String text);
}
