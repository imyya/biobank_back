package com.example.biobanque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEchantillonRepository extends JpaRepository<TypeEchantillonRepository, Long> {
}
