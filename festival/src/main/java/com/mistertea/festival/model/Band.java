package com.mistertea.festival.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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