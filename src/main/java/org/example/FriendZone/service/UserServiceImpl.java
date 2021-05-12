package org.example.FriendZone.service;

import org.example.FriendZone.model.User;
import org.example.FriendZone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(new User(user.getFirstName(),
                user.getLastName(), user.getUsername(), user.getPassword()));

    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void addHobbies(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            User existingUser = userRepository.findByUsername(user.getUsername());
            existingUser.setHobbies(user.getHobbies());

            User newUser = userRepository.save(existingUser);
            System.out.println(user.getHobbies());
        };
    }


}



//   @Override
//   public User findUser(Integer userId){
//        if(userRepository.existsById(userId)){
//            return userRepository.getOne(userId);
//        } else {
//            return null;
//        }
//   }

//    @Override
//    public String deleteUser(Integer userId) {
//        if(userRepository.existsById(userId)){
//            userRepository.deleteById(userId);
//            return "User deleted successfully";
//        } else {
//            return "User not found";
//        }
//    }