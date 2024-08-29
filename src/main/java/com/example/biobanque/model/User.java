package com.example.biobanque.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "firstname is required")
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String image;

    @ManyToOne
    @JoinColumn(name = "role")

    private Role role;


}
