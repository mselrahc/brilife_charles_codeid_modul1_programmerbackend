package com.brilife.backend.repositories;

import com.brilife.backend.entities.Contraception;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContraceptionRepository extends JpaRepository<Contraception, Integer> {
    
}