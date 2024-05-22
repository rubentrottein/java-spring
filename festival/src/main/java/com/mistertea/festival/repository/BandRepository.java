package com.mistertea.festival.repository;

import com.mistertea.festival.model.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends CrudRepository<Band, Long> {
}
