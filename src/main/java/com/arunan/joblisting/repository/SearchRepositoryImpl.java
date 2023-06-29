package com.arunan.joblisting.repository;

import com.arunan.joblisting.model.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.JobName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<JobPost> searchByText(String text) {
        final List<JobPost> aPosts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("arunan");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "searchindex")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("profile", "desc", "techs")))),
                new Document("$sort",
                        new Document("exp", 1L))));
        result.forEach(doc -> aPosts.add(mongoConverter.read(JobPost.class, doc)));
        return aPosts;
    }
}
