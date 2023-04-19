package com.example.lab4_20200638.repository;

import com.example.lab4_20200638.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
