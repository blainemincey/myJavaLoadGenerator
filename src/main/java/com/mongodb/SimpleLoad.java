package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Logger;

/**
 * Created by bmincey on 3/24/17.
 */
public class SimpleLoad {

    private static Logger LOG = Logger.getLogger(SimpleLoad.class.getName());

    /**
     *
     */
    public SimpleLoad() {

        LOG.info("Initializing...");

        this.init();
    }

    /**
     *
     */
    private void init() {

        // Localhost URI
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");

        // Example Atlas URI
        //MongoClientURI uri = new MongoClientURI(
        //        "mongodb://<USERNAME>:<PASSWORD>@mycluster-shard-00-00.mongodb.net:27017,mycluster-shard-00-01.mongodb.net:27017,mycluster-shard-00-02.mongodb.net:27017/<DATABASE>?ssl=true&replicaSet=mycluster-shard-00&authSource=admin");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("blaineDB");

        //MongoDatabase database = mongoClient.getDatabase("mydb");

        MongoCollection<Document> collection = database.getCollection("myCollection");

        for (int i = 0; i < 1000; i++) {

            // create a document
            Document document = new Document("name", "MongoDB")
                    .append("type", "database")
                    .append("count", i)
                    .append("info", new Document("x", i).append("y", i));


            // sleep for a half second
            /**
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.err.println(e);
            }
             */

            // insert doc
            collection.insertOne(document);

            LOG.info("Inserted document count: " + i);
        }

        LOG.info("Ending...");
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        new SimpleLoad();

    }
}
