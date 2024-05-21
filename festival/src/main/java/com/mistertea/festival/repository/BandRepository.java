package com.mistertea.festival.repository;

import com.mistertea.festival.model.Band;
import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, Long> {
}
