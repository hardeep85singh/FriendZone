package org.example.FriendZone.controller;

import org.example.FriendZone.exceptions.UserNotFoundException;
import org.example.FriendZone.model.User;
import org.example.FriendZone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
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



    //Post/users
//    @PostMapping("/users/signup")
//    public ResponseEntity<Object> addUser(@RequestBody User user){
//        User savedUser = userService.createUser(user);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getUsername())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }
    //Get /user/{id}

//    @GetMapping("users/{id}")
//    public User getUser(@PathVariable Integer id){
//        User user = userService.findUser(id);
//        if(user == null){
//            throw new UserNotFoundException("id- " + id);
//        }
//        return user;
//    }

//Delete /user/{id}
//    @DeleteMapping("users/{id}")
//    public String deleteUser(@PathVariable Integer id){
//        return userService.deleteUser(id);
//    }
