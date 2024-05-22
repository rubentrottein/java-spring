package com.mistertea.festival.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "band_id")
    private Long id;

    @Column(name= "band_name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "scene_id")
    private Scene scene;

}