package com.example.lab4_20200638.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idvuelo")
    private int idvuelo;

    @Column(name = "origen",nullable = false)
    private String origen;

    @Column(name = "destino",nullable = false)
    private String destino;

    @Column(name = "fecha_salida",nullable = false)
    private String fechaSalida;

    @Column(name = "fecha_llegada",nullable = false)
    private String fecheLlegada;

    @Column (name = "duracion",nullable = false)
    private int duracion;

    @Column(name = "precio",nullable = false)
    private float precio;

    @Column(name = "asientos_disponibles",nullable = false)
    private String asientosDisponibles;

    @Column (name = "descripcion",nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idaerolinea",nullable = false)
    private Aerolinea aerolinea;

    public int getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(int idvuelo) {
        this.idvuelo = idvuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFecheLlegada() {
        return fecheLlegada;
    }

    public void setFecheLlegada(String fecheLlegada) {
        this.fecheLlegada = fecheLlegada;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(String asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }
}
