package com.payme.app.repository;

import com.payme.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    default Optional<User> getUserByName(String name) {
        return findByName(name);
    }

    List<User> findContactListByName(String name);

}
