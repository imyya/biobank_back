package com.example.biobanque.repository;

import com.example.biobanque.model.Echantillon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchantillonRepository extends JpaRepository<Echantillon, Long> {
}
