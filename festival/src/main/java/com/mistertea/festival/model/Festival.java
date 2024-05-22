package com.mistertea.festival.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="festival_id")
    private Long id;


    @Column(name="festival_name")
    private String name;

    // liste scène
    @OneToMany
    List<Scene> scenesList = new ArrayList<>();
}
