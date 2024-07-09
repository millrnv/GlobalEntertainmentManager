package com.example.tallerRecuperativo.model;

public class Cliente {

    private int id;
    private String nombre, email,direccion,nTelefonico, preferencias;

    //constructor
    public Cliente(int id, String nombre, String email, String direccion, String nTelefonico, String preferencias) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.nTelefonico = nTelefonico;
        this.preferencias = preferencias;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getnTelefonico() {
        return nTelefonico;
    }

    public void setnTelefonico(String nTelefonico) {
        this.nTelefonico = nTelefonico;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
}
