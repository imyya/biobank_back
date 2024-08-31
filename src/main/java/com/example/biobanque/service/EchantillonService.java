package com.example.biobanque.service;
import com.example.biobanque.exception.ResourceNotFound;
import com.example.biobanque.model.Echantillon;
import com.example.biobanque.model.TypeEchantillon;
import com.example.biobanque.model.User;
import com.example.biobanque.repository.EchantillonRepository;
import com.example.biobanque.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EchantillonService {
    @Autowired
    EchantillonRepository echantillonRepository;
    UserService userService;
    TypeEchantillonService teService;


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

    @Transactional
    public Echantillon update(Long id, Echantillon e){
        return echantillonRepository.findById(id).map(s->{
            if(e.getDonneur() !=null && e.getDonneur().getId()!=null && e.getTypeEchantillon()!=null && e.getTypeEchantillon().getId()!=null){
                User u = userService.getById(e.getDonneur().getId()).orElseThrow(()->new ResourceNotFound("User with id: "+e.getDonneur().getId()+" not found"));
                TypeEchantillon te = teService.getById(e.getTypeEchantillon().getId()).orElseThrow(()-> new ResourceNotFound("Type-Echantillon with id: "+e.getTypeEchantillon().getId()+" not found"));
                teService.save(te);
                userService.save(u);
            }
            if(e.getCode()!=null){
                s.setCode(e.getCode());
            }
            if(e.getResultat()!=null){
                s.setResultat(e.getResultat());
            }
            if(e.getDateCollect()!=null){
                s.setDateCollect(e.getDateCollect());
            }

            return echantillonRepository.save(s);


        }).orElseThrow(()->new ResourceNotFound("Sample not found"));
    }


}
