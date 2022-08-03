package com.myshoppe.fruitstand.model;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @Column(name = "artist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String instagram;
    private String twitter;



}
