package com.example.inventario.modelos;

public class Cliente {

    private String id;
    private String cliente;
    private String nombre;
    private String telefono;
    private String email;

    public Cliente() {
    }

    public Cliente(String id, String cliente, String nombre, String telefono, String email) {
        this.id = id;
        this.cliente = cliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
