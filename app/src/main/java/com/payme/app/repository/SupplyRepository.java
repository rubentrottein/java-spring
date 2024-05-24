package com.payme.app.repository;

import com.payme.app.model.Supply;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends CrudRepository<Supply, Long> {
}
