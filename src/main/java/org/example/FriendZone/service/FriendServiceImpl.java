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



//    List<User> users = new LinkedList<>();
//        for (String str: friendRepository.getAllFriends(userId)){
//                User user = new User();
//                user.setFirstName(str);
//                user.setLastName(str);
//                user.setUsername(str);
//                users.add(user);
//                System.out.println(user.getFirstName());
//                }
//
//                System.out.println(users.toString());
//                return users;
