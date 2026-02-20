package com.example.cards;

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
    private int idImagen;

    public Planta(int id, String nombre, String familia, String valorCulinario, int altura, String descripcion, String origen, int idImagen) {
        this.id = id;
        this.nombre = nombre;
        this.familia = familia;
        this.valorCulinario = valorCulinario;
        this.altura = altura;
        this.descripcion = descripcion;
        this.origen = origen;
        this.idImagen = idImagen;
    }

    public Planta(Document doc) {
        nombre = doc.getString("nombre");
        familia = doc.getString("familia");
        valorCulinario = doc.getString("valorCulinario");
        altura = doc.getInteger("altura");
        descripcion = doc.getString("descripcion");
        origen = doc.getString("origen_nombre");
        // TODO imagen
        idImagen = R.drawable.ic_launcher_background;
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

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
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
                ", idImagen=" + idImagen +
                '}';
    }
}