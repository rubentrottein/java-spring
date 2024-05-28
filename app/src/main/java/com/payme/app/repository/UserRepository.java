package com.payme.app.repository;

import com.payme.app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getUserByName(String name);

    List<User> findContactListByName(String name);
}
