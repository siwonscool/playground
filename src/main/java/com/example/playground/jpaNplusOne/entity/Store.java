package com.example.playground.jpaNplusOne.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Store(String name) {
        this.name = name;
    }
}
