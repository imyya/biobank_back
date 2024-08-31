package com.example.biobanque.service;

import com.example.biobanque.model.TypeEchantillon;
import com.example.biobanque.model.User;
import com.example.biobanque.repository.TypeEchantillonRepository;
import com.example.biobanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class TypeEchantillonService {
    @Autowired
    TypeEchantillonRepository repo;

    public List<TypeEchantillon> getAll(){return repo.findAll();}

    public Optional<TypeEchantillon> getById(Long id){
        return repo.findById(id);
    }


    public TypeEchantillon save(TypeEchantillon te){
        return repo.save(te);
    }

}
