package org.example.FriendZone.repository;

import org.example.FriendZone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUserName(String username);

    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
