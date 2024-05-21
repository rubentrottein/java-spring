package com.mistertea.festival.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
// @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor // = annotation@Data (lombok)
@Data
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="festival_id");
    private Long id;

    private String name;

    // liste scène
    @OneToMany
    List<Scene> scenesList = new ArrayList<>();
}
