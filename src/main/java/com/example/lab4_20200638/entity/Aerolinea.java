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

    public int getIdaerolinea() {
        return idaerolinea;
    }

    public void setIdaerolinea(int idaerolinea) {
        this.idaerolinea = idaerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
