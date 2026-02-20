package com.example.cards;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // btener referencia al RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPlantas);

        // Definir que la lista sea lineal (vertical)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear los datos
        List<Planta> plantas = crearDatos();

        // Crear y asignar el adaptador
        PlantaAdapter adapter = new PlantaAdapter(plantas, new PlantaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Planta planta) {
                // Al hacer clic, abrimos la segunda actividad
                abrirDetalle(planta);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void abrirDetalle(Planta planta) {
        Intent intent = new Intent(MainActivity.this, Detalle.class);
        // Pasamos el objeto con una clave
        intent.putExtra("EXTRA_PLANTA", planta);
        startActivity(intent);
    }

    // Método auxiliar para generar datos de prueba
    private List<Planta> crearDatos() {
        List<Planta> list = new ArrayList<>();
        list.add(new Planta(1, "Albahaca", "Lamiáceas", "Alto", 40, "Hierba aromática esencial para el pesto.", "India", R.drawable.albahaca));
        list.add(new Planta(2, "Lavanda", "Lamiáceas", "Bajo", 60, "Famosa por su fragancia y propiedades relajantes.", "Mediterráneo", R.drawable.lavanda));
        list.add(new Planta(3, "Menta", "Lamiáceas", "Medio", 30, "Planta refrescante de crecimiento muy rápido.", "Europa", R.drawable.menta));
        list.add(new Planta(4, "Cactus de Asiento", "Cactáceas", "Nulo", 50, "Planta suculenta globosa con espinas amarillas.", "México", R.drawable.cactus));
        list.add(new Planta(5, "Romero", "Lamiáceas", "Alto", 150, "Arbusto leñoso muy utilizado en guisos y carnes.", "Mediterráneo", R.drawable.romero));
        list.add(new Planta(6, "Girasol", "Asteráceas", "Medio", 200, "Planta que sigue la ruta del sol durante el día.", "Norteamérica", R.drawable.girasol));
        list.add(new Planta(7, "Helecho Espada", "Polypodiaceae", "Nulo", 90, "Planta ornamental clásica para interiores sombríos.", "Zonas Tropicales", R.drawable.helecho));
        list.add(new Planta(8, "Orquídea Phalaenopsis", "Orchidaceae", "Nulo", 45, "Flor elegante conocida como orquídea mariposa.", "Sudeste Asiático", R.drawable.orquidea));
        list.add(new Planta(9, "Aloe Vera", "Asphodelaceae", "Bajo", 60, "Conocida por las propiedades medicinales de su gel.", "África", R.drawable.aloe));
        list.add(new Planta(10, "Bambú de la Suerte", "Asparagaceae", "Nulo", 100, "Común en decoración, técnicamente es una Dracaena.", "África Central", R.drawable.bambu));
        return list;
    }
}