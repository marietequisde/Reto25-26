package com.example.reto;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reto.db.AccesoPlantas;

import java.util.ArrayList;
import java.util.List;

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