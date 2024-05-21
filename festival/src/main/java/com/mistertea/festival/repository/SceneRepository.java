package com.mistertea.festival.repository;

import com.mistertea.festival.model.Scene;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SceneRepository extends CrudRepository<Scene, Long>{
	
}
