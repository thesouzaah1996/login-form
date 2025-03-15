package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

    Login findByEmail(String email);    
}
