package org.example.FriendZone.repository;

import org.example.FriendZone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Boolean existsByUsername(String username);

    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.firstName LIKE %?1%"
    + " OR u.lastName LIKE %?1%"
    + " OR u.username LIKE %?1%")
    List<User> searchUsers(String keyword);



//    @Query("SELECT u form users u WHERE CONCAT(u.firstName, u.lastName, u.username) LIKE %?1%"


}
