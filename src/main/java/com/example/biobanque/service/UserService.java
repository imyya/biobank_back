package com.example.biobanque.service;
import com.example.biobanque.model.Echantillon;
import com.example.biobanque.model.User;
import com.example.biobanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> getById(Long id){
        return userRepo.findById(id);
    }
    public User save(User user){
        return userRepo.save(user);
    }

}
