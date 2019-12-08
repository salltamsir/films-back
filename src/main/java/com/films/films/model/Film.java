package com.films.films.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Film {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String synopsis;
    private int annee;
    private String urlImage;
    private Float prix;
    @Enumerated(EnumType.STRING)
    private Type type;


}
