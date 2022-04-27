package com.example.inventario.modelos;

public class Producto {

    private String id;
    private String nombre;
    private String rack;
    private String tipo_producto;
    private String unidad_medida;
    private double existencia;

    public Producto() {
    }


    public Producto(String id, String nombre, String rack, String tipo_producto, String unidad_medida, double existencia) {
        this.id = id;
        this.nombre = nombre;
        this.rack = rack;
        this.tipo_producto = tipo_producto;
        this.unidad_medida = unidad_medida;
        this.existencia = existencia;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public double getExistencia() {
        return existencia;
    }

    public void setExistencia(double existencia) {
        this.existencia = existencia;
    }
}
