package com.mistertea.festival.repository;

import com.mistertea.festival.model.Festival;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivalRepository extends CrudRepository<Festival, Long> {
}
