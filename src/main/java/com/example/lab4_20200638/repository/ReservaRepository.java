package com.example.lab4_20200638.repository;


import com.example.lab4_20200638.entity.Reserva;
import com.example.lab4_20200638.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO reserva (fecha_reserva, precio_total, estado_pago, user_iduser, vuelo_idvuelo) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void guardarReserva(String fecha, double precio, String estado, int idUsuario, int idVuelo);
}
