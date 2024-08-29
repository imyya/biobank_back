package com.example.biobanque.controller;

import com.example.biobanque.exception.ResourceNotFound;
import com.example.biobanque.model.Echantillon;
import com.example.biobanque.model.User;
import com.example.biobanque.service.EchantillonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/bio")
public class EchantillonController {
    @Autowired
    EchantillonService echantillonService;
    Echantillon e;
    User donor;

    @GetMapping("/samples")

    public ResponseEntity<List<Echantillon>> getAllSamples(){
        List<Echantillon> samples= echantillonService.getAll();
        return ResponseEntity.ok(samples);
    }

    @GetMapping("/samples/{id}")
    public ResponseEntity<Echantillon> getSampleById(@PathVariable(value="id") Long id){
        Echantillon e = echantillonService.getById(id).orElseThrow(()->new ResourceNotFound("Sample with id: "+id+" not found"));
        return ResponseEntity.ok(e);
    }

    @PostMapping("/samples")

    public Echantillon createSample(@RequestBody Echantillon e){
        return echantillonService.save(e);
    }

    @PutMapping("/smaples/{id}")
    public ResponseEntity<Echantillon> updateSample(@PathVariable(value="id") Long id){
        Echantillon e = echantillonService.getById(id).orElseThrow(()-> new ResourceNotFound("Sample with id: "+id+" not found"));
        return ResponseEntity.ok(e);
    }


}
