package org.example.FriendZone.controller;

import org.example.FriendZone.exceptions.UserNotFoundException;
import org.example.FriendZone.model.User;
import org.example.FriendZone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Get/users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    //Post/users
    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        User savedUser = userService.createUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getEmailId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    //Get /user/{id}

    @GetMapping("users/{id}")
    public User getUser(@PathVariable Integer id){
        User user = userService.findUser(id);
        if(user == null){
            throw new UserNotFoundException("id- " + id);
        }
        return user;
    }

    //Delete /user/{id}
    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
