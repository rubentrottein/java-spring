package com.mistertea.festival.service;

import com.mistertea.festival.model.Festival;
import com.mistertea.festival.model.Scene;
import com.mistertea.festival.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalService {
    @Autowired
    FestivalRepository festivalRepository;

    public List<Festival> getAllFestivals() {
        return (List<Festival>) festivalRepository.findAll();
    }

    public Festival addFestival(Festival festival) {
        return festivalRepository.save(festival);
    }

    public List<Scene> addScene(Festival festival, Scene scene) {
        festival.getScenesList().add(scene);
        return festival.getScenesList();
    }

    public Festival getFestivalById(Long id) {
        if(festivalRepository.findById(id).isPresent()) {
            return festivalRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public List<Scene> getFestivalScenes(Festival festival) {
        return festival.getScenesList();
    }
}