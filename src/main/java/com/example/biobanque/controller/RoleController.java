package com.example.biobanque.controller;

import com.example.biobanque.exception.ResourceNotFound;
import com.example.biobanque.model.Role;
import com.example.biobanque.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bio")

public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> allRoles(){
        List<Role> roles = roleService.getAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(value="id") Long id){
        Role r = roleService.findById(id).orElseThrow(()->new ResourceNotFound("Role with id: "+id+" not found"));
        return ResponseEntity.ok(r);
    }


}
