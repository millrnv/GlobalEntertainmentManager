package com.example.tallerRecuperativo.model;

public class Actividad {

    private int id, edadMin;
    private String nombreActividad, fecha, lugar, duracion;

    //constructor
    public Actividad(int id, String nombreActividad, int edadMin, String fecha, String lugar, String duracion) {
        this.id = id;
        this.nombreActividad = nombreActividad;
        this.edadMin = edadMin;
        this.fecha = fecha;
        this.lugar = lugar;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
