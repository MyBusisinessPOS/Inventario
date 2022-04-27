package com.example.inventario.modelos;

public class Proveedor {

    private String id;
    private String proveedor;
    private String nombre;
    private String telefono;
    private String email;

    public Proveedor() {
    }

    public Proveedor(String id, String proveedor, String nombre, String telefono, String email) {
        this.id = id;
        this.proveedor = proveedor;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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
