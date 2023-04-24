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
    @JoinColumn(name = "vuelo_idvuelo",nullable = false)
    private Vuelo vuelo;

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
}


