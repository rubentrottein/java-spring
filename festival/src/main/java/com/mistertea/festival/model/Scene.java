package com.mistertea.festival.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Festival;

    // Liste Concerts
}
