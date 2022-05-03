package com.example.inventario.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity(nameInDb = "users")
public class Productos {

    @Id(autoincrement = false)
    private long id = 1;
    private String nombre;
    private String rack;
    private String tipo_producto;
    private String unidad_medida;
    private double existencia;
    @Generated(hash = 1572023464)
    public Productos(long id, String nombre, String rack, String tipo_producto,
            String unidad_medida, double existencia) {
        this.id = id;
        this.nombre = nombre;
        this.rack = rack;
        this.tipo_producto = tipo_producto;
        this.unidad_medida = unidad_medida;
        this.existencia = existencia;
    }
    @Generated(hash = 1055668858)
    public Productos() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRack() {
        return this.rack;
    }
    public void setRack(String rack) {
        this.rack = rack;
    }
    public String getTipo_producto() {
        return this.tipo_producto;
    }
    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }
    public String getUnidad_medida() {
        return this.unidad_medida;
    }
    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }
    public double getExistencia() {
        return this.existencia;
    }
    public void setExistencia(double existencia) {
        this.existencia = existencia;
    }

    
}
