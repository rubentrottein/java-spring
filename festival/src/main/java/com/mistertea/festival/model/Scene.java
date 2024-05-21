package com.mistertea.festival.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "scene_id")
    private Long id;

    @Column(name= "scene_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "festival_id")
    private Festival festival;

    // Liste Concerts
}
