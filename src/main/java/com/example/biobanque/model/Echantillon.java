package com.example.biobanque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="echantillon")
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "code is required")
    private String code;
    private Date dateCollect;
    private String resultat;


    @ManyToOne
    @JoinColumn(name="type_id")
    private TypeEchantillon typeEchantillon;

    @ManyToOne
    @JoinColumn(name="donneur_id")
    private User donneur;

}
