package com.mistertea.festival.service;

import com.mistertea.festival.model.Scene;
import com.mistertea.festival.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneService {
	@Autowired
	SceneRepository sceneRepository;

	public List<Scene> getAllScenes() {
		return (List<Scene>) sceneRepository.findAll();
	}

	public Scene addScene(Scene scene) {
		return sceneRepository.save(scene);
	}
}
