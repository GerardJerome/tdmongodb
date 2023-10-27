package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class Update {

    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("td");
            MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("people");

            // update one document
            Bson filter = eq("name", "people1.0");
            Bson updateOperation = set("comment", "You should learn MongoDB mais vraiment!");
            UpdateResult updateResult = gradesCollection.updateOne(filter, updateOperation);
            System.out.println("=> Updating the doc with {\"name\":people1.0}. Adding comment.");
            System.out.println(updateResult);


            // update many documents
            Bson Update2 = set("Update","UPDATE DE MASSE");
            filter = eq("sexe", "f");
            updateResult = gradesCollection.updateMany(filter, Update2);
            System.out.println("\n=> Updating all the documents with {\"sexe\":f}.");
            System.out.println(updateResult);

        }
    }
}
