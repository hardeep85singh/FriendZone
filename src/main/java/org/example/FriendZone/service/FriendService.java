package org.example.FriendZone.service;

import org.example.FriendZone.model.User;

import java.util.List;

public interface FriendService {

    void addFriendById(Long userId, Long friendId);

    List<User> getAllFriends(Long userId);

}
