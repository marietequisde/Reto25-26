package com.example.cards;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.bson.Document;

import java.io.Serializable;

public class Planta implements Serializable {

    // Atributos
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String familia;
    private String valorCulinario;
    private int altura; // En centrimetros
    private String descripcion;
    private String origen;
    private String imagen;

    public Planta(Document doc) {
        nombre = doc.getString("nombre");
        familia = doc.getString("familia");
        valorCulinario = doc.getString("valorCulinario");
        altura = doc.getInteger("altura");
        descripcion = doc.getString("descripcion");
        origen = doc.getString("origen_nombre");
        imagen = doc.getString("imagen");
    }

    private static Bitmap decodeBase64(String base64) {
        if (base64 != null && !base64.isEmpty()) {
            final String cabecera = "data:image/webp;base64,";
            final String base64SinCabecera = base64.substring(cabecera.indexOf(","));
            byte[] bytes = Base64.decode(base64SinCabecera, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        return null;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getValorCulinario() {
        return valorCulinario;
    }

    public void setValorCulinario(String valorCulinario) {
        this.valorCulinario = valorCulinario;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Bitmap getImagen() {
        return decodeBase64(imagen);
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", familia='" + familia + '\'' +
                ", valorCulinario='" + valorCulinario + '\'' +
                ", altura=" + altura +
                ", descripcion='" + descripcion + '\'' +
                ", origen='" + origen + '\'' +
                '}';
    }
}