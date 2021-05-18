package org.example.FriendZone.controller;

import org.example.FriendZone.model.User;
import org.example.FriendZone.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    @PostMapping ("/friends")
    public ResponseEntity<String> addFriend(@RequestBody Map<String, Long> object){
        long userId = object.get("userId");
        long friendId = object.get("friendId");

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("")
                .buildAndExpand().toUri();
        if(userId != friendId){
            friendService.addFriendById(userId, friendId);
            return ResponseEntity.created(uri).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/friends/{id}")
    public List<User> getAllFriends(@PathVariable Long id){
        return friendService.getAllFriends(id);
    }
}
