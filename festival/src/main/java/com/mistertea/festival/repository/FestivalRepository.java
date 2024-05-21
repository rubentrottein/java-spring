package com.mistertea.festival.repository;

import com.mistertea.festival.model.Festival;
import org.springframework.data.repository.CrudRepository;

public interface FestivalRepository extends CrudRepository<Festival, Long> {
}
