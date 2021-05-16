package org.example.FriendZone.repository;

import org.example.FriendZone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FriendRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "INSERT INTO friends (id, friend_id) VALUES (:userId, :friendId)", nativeQuery = true)
    void saveByUserId(@Param("userId") Long userId, @Param("friendId") Long friendId);

    @Query(value = ("Select u.first_name, u.last_name, u.username "
            + "from users u "
            + "join friends f on f.friend_id = ?1"), nativeQuery = true)
    List<String> getAllFriends(Long id);
}

//    SELECT u FROM User u WHERE u.firstName LIKE %?1%
//SELECT u form users u WHERE CONCAT(u.firstName, u.lastName, u.username) LIKE %?1%



//@Query(value = ("Select users.first_name, users.last_name, users.username "
//        + "from users, friends "
//        + "where friends.friend_id = ?1"), nativeQuery = true)