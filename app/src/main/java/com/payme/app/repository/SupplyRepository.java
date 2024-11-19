package com.payme.app.repository;

import com.payme.app.model.Supply;
import com.payme.app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplyRepository extends CrudRepository<Supply, Long> {
    List<Supply> findByUser(Optional<User> user);
}
