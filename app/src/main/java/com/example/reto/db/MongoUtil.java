package com.example.reto.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {

    public static MongoDatabase abrirConexion() {
        MongoClientURI uri = new MongoClientURI( "mongodb://10.0.2.2:27017/plantas" );
        MongoClient mongoClient = new MongoClient(uri);
        return mongoClient.getDatabase(uri.getDatabase());
    }
}
