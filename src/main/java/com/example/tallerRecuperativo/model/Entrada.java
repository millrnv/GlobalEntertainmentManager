package com.example.tallerRecuperativo.model;

public class Entrada {

    private int id, disponibilidad;
    private String tipoEntrada;
    private double precio;
    private Actividad actividad;
    private Cliente cliente;


    //constructor
    public Entrada(int id, Actividad actividad, Cliente cliente, String tipoEntrada, int disponibilidad, double precio) {
        this.id = id;
        this.actividad = actividad;
        this.cliente = cliente;
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

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
