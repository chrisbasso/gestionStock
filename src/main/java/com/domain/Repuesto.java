package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Repuesto {

    @Id
    private long id;

    private long version;
    private int cantidad;
    private double precio;
    private String descripcion;
    private String modelo;
    private String nombre;
    private String anio;
    private String marca;

    public Repuesto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Repuesto{" +
                "id=" + id +
                ", version=" + version +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", modelo='" + modelo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", anio='" + anio + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}