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


}
