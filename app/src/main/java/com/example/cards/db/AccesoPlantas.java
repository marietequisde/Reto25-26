package com.example.cards.db;

import com.example.cards.Planta;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AccesoPlantas {

    public static List<Planta> obtenerPlantas() {
        MongoDatabase db = MongoUtil.abrirConexion();
        List<Planta> plantas = new ArrayList<>();

        MongoCursor<Document> docs = db.getCollection("vista_plantas").find().cursor();
        while (docs.hasNext()) {
            Document doc = docs.next();
            plantas.add(new Planta(doc));
        }

        return plantas;
    }

}
