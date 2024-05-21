package com.mistertea.festival.service;

import com.mistertea.festival.model.Festival;
import com.mistertea.festival.model.Scene;
import com.mistertea.festival.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FestivalService {
    @Autowired
    private FestivalRepository festivalRepository;

    public boolean addFestival(Festival festival) {
        festivalRepository.save(festival);
        return true;
    }

    public List<Scene> addScene(Festival festival, Scene scene) {
        festival.getScenesList().add(scene);
        return festival.getScenesList();
    }

    public List<Festival> getAllFestivals() {
        return (List<Festival>) festivalRepository.findAll();
    }

    public Festival getFestivalById(Long id) {
        if(festivalRepository.findById(id).isPresent()) {
            return festivalRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public List<Scene> getScenes(Festival festival) {
        return festival.getScenesList();
    }
}