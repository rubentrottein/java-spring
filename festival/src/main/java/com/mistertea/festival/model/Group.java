package com.mistertea.festival.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "scene_id")
    private Long id;

    @Column(name= "band_name")
    private String name;
    
    @ManyToMany
    @JoinColumn(name = "scene_id")
    private Scene = scene;

    // liste scène
    @ManyToMany
    List<Scene> scenesList = new ArrayList<>();
}
