package com.example.biobanque.controller;

import com.example.biobanque.exception.ResourceNotFound;
import com.example.biobanque.model.User;
import com.example.biobanque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/bio")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> allUsers(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);

    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value="id") Long id){
        User u= userService.getById(id).orElseThrow(()->new ResourceNotFound("no user found with id: "+id));
        return ResponseEntity.ok(u);
    }




}
