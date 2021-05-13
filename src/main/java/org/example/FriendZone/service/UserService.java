package org.example.FriendZone.service;

import org.example.FriendZone.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);

    public List<User> findAllUsers();

    void addHobbies(User user);

    public User getUser(String username);

    List<User> searchUser(String keyword);



}
