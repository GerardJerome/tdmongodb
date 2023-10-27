package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

public class Delete {

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("grades");

            // delete one document
            Bson filter = eq("name", "people1.0");
            DeleteResult result = gradesCollection.deleteOne(filter);
            System.out.println(result);



            // delete many documents
            filter = eq("name", "people2.0");
            result = gradesCollection.deleteMany(filter);
            System.out.println(result);

            // delete the entire collection and its metadata (indexes, chunk metadata, etc).
            //gradesCollection.drop();
        }
    }
}
