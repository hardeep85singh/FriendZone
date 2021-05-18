package org.example.FriendZone.service;

import org.example.FriendZone.model.User;
import org.example.FriendZone.repository.FriendRepository;
import org.example.FriendZone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("friendService")

public class FriendServiceImpl implements FriendService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    FriendRepository friendRepository;

    @Override
    public void addFriendById(Long userId, Long friendId) {
        friendRepository.saveByUserId(userId, friendId);
    }

    @Override
    public List<User> getAllFriends(Long userId) {
        List<Long> userIds = friendRepository.getAllFriends(userId);
        List<User> friendList = new LinkedList<>();
        for(Long id: userIds){
            User user = userRepository.findByUserId(id);
            friendList.add(user);
        }
        return  friendList;
    }

}

