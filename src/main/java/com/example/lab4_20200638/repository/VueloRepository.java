package com.example.lab4_20200638.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lab4_20200638.entity.Vuelo;

import java.util.Vector;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

    Vuelo findVueloByIdvuelo(int id);

}
