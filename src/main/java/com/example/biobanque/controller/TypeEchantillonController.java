package com.example.biobanque.controller;

import com.example.biobanque.exception.ResourceNotFound;
import com.example.biobanque.model.TypeEchantillon;
import com.example.biobanque.service.TypeEchantillonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("api/bio")
public class TypeEchantillonController {
    @Autowired
    TypeEchantillonService typeEchService;

    @GetMapping("/types")
    public ResponseEntity<List<TypeEchantillon>> allTypes(){
        List<TypeEchantillon> types = typeEchService.getAll();
        return ResponseEntity.ok(types);
    }

    @GetMapping("/types/{id}")
    public ResponseEntity<TypeEchantillon> getTypeById(@PathVariable(value="id") Long id){
        TypeEchantillon type = typeEchService.getById(id).orElseThrow(()->new ResourceNotFound("no sample type with this id: "+id+"was found"));
        return ResponseEntity.ok(type);
    }
}
