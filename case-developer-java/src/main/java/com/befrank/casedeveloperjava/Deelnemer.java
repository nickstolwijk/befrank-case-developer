package com.befrank.casedeveloperjava;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Deelnemer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }
}
