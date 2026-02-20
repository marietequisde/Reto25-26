package com.example.reto;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlantaAdapter extends RecyclerView.Adapter<PlantaAdapter.PlantaViewHolder> {

    private List<Planta> plantas;
    private OnItemClickListener listener;

    // Interfaz para comunicar el clic a la Actividad
    public interface OnItemClickListener {
        void onItemClick(Planta planta);
    }

    // Constructor del adaptador
    public PlantaAdapter(List<Planta> plantas, OnItemClickListener listener) {
        this.plantas = plantas;
        this.listener = listener;
    }

    // Clase interna ViewHolder: Mantiene referencias a las vistas
    public static class PlantaViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivImagen;
        public TextView tvNombre, tvFamilia, tvValor;

        public PlantaViewHolder(View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivPlantaImage);
            tvNombre = itemView.findViewById(R.id.tvNombrePlanta);
            tvFamilia = itemView.findViewById(R.id.tvFamilia);
            tvValor = itemView.findViewById(R.id.tvValor);
        }

        // Método auxiliar para vincular datos y listener
        public void bind(final Planta planta, final OnItemClickListener listener) {
            tvNombre.setText(planta.getNombre());
            tvFamilia.setText("Familia: " + planta.getFamilia());
            String valor = planta.getValorCulinario();
            tvValor.setText("Valor culinario: " + valor);
            // Dependiendo del valor culinario, cambiamos el color del texto

            // Obtenemos el contexto desde la vista
            android.content.Context context = itemView.getContext();
            switch (valor) {
                case "Alto":
                    tvValor.setTextColor(ContextCompat.getColor(context, R.color.verde));
                    break;
                case "Medio":
                    tvValor.setTextColor(ContextCompat.getColor(context, R.color.naranja));
                    break;
                case "Bajo":
                    tvValor.setTextColor(ContextCompat.getColor(context, R.color.rojo));
                    break;
                default:
                    tvValor.setTextColor(Color.BLACK);
                    break;
            }

            ivImagen.setImageBitmap(planta.getImagen());

            // Configurar el clic en toda la tarjeta
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(planta);
                }
            });
        }
    }

    @NonNull
    @Override
    public PlantaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout item_planta.xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.planta_item, parent, false);
        return new PlantaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantaViewHolder holder, int position) {
        // Obtenemos el planta actual y llamamos al método bind
        holder.bind(plantas.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return plantas.size();
    }
}