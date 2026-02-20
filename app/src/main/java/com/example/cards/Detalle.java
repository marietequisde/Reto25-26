package com.example.cards;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // Recuperar el objeto Planta enviado desde el MainActivity
        // Usamos getSerializableExtra y casteamos a (Planta) porque la clase implementa Serializable
        Planta planta = (Planta) getIntent().getSerializableExtra("EXTRA_PLANTA");

        // Vincular las variables con los componentes del layout XML
        ImageView ivImagen = findViewById(R.id.ivImagen);
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvDatos = findViewById(R.id.tvDatos);
        TextView tvDescripcion = findViewById(R.id.tvDescripcion);
        TextView tvOrigen = findViewById(R.id.tvOrigen);
        Button btnVolver = findViewById(R.id.btnVolver);

        // Verificar que el objeto no sea nulo para evitar errores (NullPointerException)
        if (planta != null) {
            // Asignar la imagen usando el bitmap
            ivImagen.setImageBitmap(planta.getImagen());
            tvNombre.setText(planta.getNombre());

            // Construir una cadena de texto combinando varios atributos
            String stats = "Familia: " + planta.getFamilia() + " | Altura: " + planta.getAltura() + " cm | Valor culinario: " + planta.getValorCulinario();
            tvDatos.setText(stats);

            // Mostrar datos
            tvDescripcion.setText(planta.getDescripcion());
            tvOrigen.setText("Origen: " + planta.getOrigen().toUpperCase());
        }

        // Configurar el botón para cerrar esta actividad y volver a la lista
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}