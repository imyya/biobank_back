package com.example.biobanque.service;
import com.example.biobanque.model.Echantillon;
import com.example.biobanque.repository.EchantillonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EchantillonService {
    @Autowired
    EchantillonRepository echantillonRepository;

    public List<Echantillon> getAll(){
        return echantillonRepository.findAll();
    }

    public Echantillon save(Echantillon e){
        return echantillonRepository.save(e);
    }

    public Optional<Echantillon> getById(Long id){
        return echantillonRepository.findById(id);
    }

    public void deleteById(Long id){
        echantillonRepository.deleteById(id);
    }





}
