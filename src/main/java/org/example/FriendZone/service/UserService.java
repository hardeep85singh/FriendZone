package org.example.FriendZone.service;

import org.example.FriendZone.model.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);

    public List<User> findAllUsers();

    public User findUser(String userId);
}
