package org.example.FriendZone.repository;

import org.example.FriendZone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Boolean existsByUsername(String username);

    User findByUsername(String username);


}
