package com.mistertea.festival.service;

import com.mistertea.festival.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SceneService {
	@Autowired
	SceneRepository repository;
}
