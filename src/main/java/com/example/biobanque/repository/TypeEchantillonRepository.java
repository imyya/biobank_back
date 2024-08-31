package com.example.biobanque.repository;

import com.example.biobanque.model.TypeEchantillon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEchantillonRepository extends JpaRepository<TypeEchantillon, Long> {
}
