package com.example.cards;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cards.db.AccesoPlantas;
import com.example.cards.db.MongoUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    List<Planta> plantas;
    PlantaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // btener referencia al RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPlantas);

        // Definir que la lista sea lineal (vertical)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        plantas = new ArrayList<>();

        // Crear y asignar el adaptador
        adapter = new PlantaAdapter(plantas, new PlantaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Planta planta) {
                // Al hacer clic, abrimos la segunda actividad
                abrirDetalle(planta);
            }
        });

        recyclerView.setAdapter(adapter);
        cargarDatos();
    }

    private void abrirDetalle(Planta planta) {
        Intent intent = new Intent(MainActivity.this, Detalle.class);
        // Pasamos el objeto con una clave
        intent.putExtra("EXTRA_PLANTA", planta);
        startActivity(intent);
    }

    // Método auxiliar para cargar los datos
    private void cargarDatos() {
        new Thread(new Runnable() {
            public void run() {
                List<Planta> nuevasPlantas = AccesoPlantas.obtenerPlantas();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        plantas.clear();
                        plantas.addAll(nuevasPlantas);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }
}