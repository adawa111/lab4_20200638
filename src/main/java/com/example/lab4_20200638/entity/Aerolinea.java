package com.example.lab4_20200638.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aerolinea")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaerolinea")
    private int idaerolinea;

    @Column (name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "codigo",nullable = false)
    private String codigo;

}
