package com.example.tallerRecuperativo.model;

public class Entrada {

    private int id, disponibilidad;
    private String tipoEntrada;
    private double precio;

    //constructor
    public Entrada(int id, String tipoEntrada, int disponibilidad, double precio) {
        this.id = id;
        this.tipoEntrada = tipoEntrada;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
