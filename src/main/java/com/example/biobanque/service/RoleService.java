package com.example.biobanque.service;

import com.example.biobanque.exception.ResourceNotFound;
import com.example.biobanque.model.Role;
import com.example.biobanque.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepo;

    public List<Role> getAll(){
        return roleRepo.findAll();
    }

    public Role save(Role role){return roleRepo.save(role);
    }

    public void delete(Long  id){ roleRepo.deleteById(id);}

    public Optional<Role> findById(Long id){return roleRepo.findById(id);}

    public Role update(Long id, Role role ){
        return roleRepo.findById(id).map(r->{
            if(role.getLibelle()!=null){
                r.setLibelle(role.getLibelle());
            }
            return roleRepo.save(r);
        }).orElseThrow(()->new ResourceNotFound("role with id: "+id+" not found"));

    }

}
