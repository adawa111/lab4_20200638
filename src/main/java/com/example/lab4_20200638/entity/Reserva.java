package com.example.lab4_20200638.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva",nullable = false)
    private int idreserva;

    @Column(name = "fecha_reserva",nullable = false)
    private String fechaReserva;

    @Column(name = "precio_total",nullable = false)
    private float precioTotal;

    @Column (name = "estado_pago",nullable = false)
    private String estadoPago;

    @ManyToOne
    @JoinColumn(name = "user_iduser",nullable = false)
    private User user;

    @ManyToOne
    @Column(name = "vuelo_idvuelo",nullable = false)
    private Vuelo vuelo;
}
