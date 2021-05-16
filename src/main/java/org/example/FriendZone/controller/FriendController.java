package org.example.FriendZone.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.example.FriendZone.model.Friend;
import org.example.FriendZone.model.User;
import org.example.FriendZone.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.ObjectName;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    @PostMapping ("/friends")
    public void addFriend(@RequestBody Map<String, Long> object){

        long userId = object.get("userId");
        long friendId = object.get("friendId");
        friendService.addFriendById(userId, friendId);
    }

    @GetMapping("/friends/{id}")
    public List<User> getAllFriends(@PathVariable Long id){
        return friendService.getAllFriends(id);
    }
}
