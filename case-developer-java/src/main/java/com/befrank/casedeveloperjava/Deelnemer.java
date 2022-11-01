package com.befrank.casedeveloperjava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Deelnemer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }
}
