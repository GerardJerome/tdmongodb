package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Create {


    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("td");
            MongoCollection<Document> peopleColelction = sampleTrainingDB.getCollection("people");


            insertManyDocuments(peopleColelction);
        }
    }


    private static void insertManyDocuments(MongoCollection<Document> peopleCollection) {
        List<Document> people = new ArrayList<>();
        for (double peopleId = 1d; peopleId <= 10d; peopleId++) {
            people.add(generateNewPeople(peopleId));
        }

        peopleCollection.insertMany(people, new InsertManyOptions().ordered(false));
        System.out.println("Ten peoples inserted for studentId 10001.");
    }

    private static Document generateNewPeople(Double id) {
        return new Document("_id", new ObjectId()).append("name", "people"+id)
                                                  .append("last name", "people last name1")
                                                  .append("sexe", "f");
    }
}
