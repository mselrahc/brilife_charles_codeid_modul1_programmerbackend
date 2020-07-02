package com.brilife.backend.repositories;

import com.brilife.backend.entities.Usage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRepository extends JpaRepository<Usage, Integer> {
    
}