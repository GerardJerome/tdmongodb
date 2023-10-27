package com.mongodb.quickstart;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

public class Read {

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("td");
            MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("people");

            // find one document with new Document
            Document student1 = gradesCollection.find(new Document("name", "people1.0")).first();
            System.out.println("Student 1: " + student1.toJson());



            // find a list of documents and use a List object instead of an iterator
            List<Document> studentList = gradesCollection.find().into(new ArrayList<>());
            System.out.println("Student list with an ArrayList:");
            for (Document student : studentList) {
                System.out.println(student.toJson());
            }
        }
    }
}
