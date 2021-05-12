package org.example.FriendZone.service;

import org.example.FriendZone.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);

    public List<User> findAllUsers();

    void addHobbies(User user);

//    public User findUser(Integer userId);
//
//    public String deleteUser(Integer userId);
}
