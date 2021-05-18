package org.example.FriendZone.controller;

import org.example.FriendZone.model.User;
import org.example.FriendZone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/hobbies")
    public void addHobbies(@RequestBody User user){
        userService.addHobbies(user);

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        System.out.println(username);
        return userService.getUser(username);

    }

    @GetMapping("/searchUser/{searchUser}")
    public List<User> searchUsers(@PathVariable String searchUser){
        return userService.searchUser(searchUser);
    }
}


