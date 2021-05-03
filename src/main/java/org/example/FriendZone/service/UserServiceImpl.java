package org.example.FriendZone.service;

import org.example.FriendZone.model.User;
import org.example.FriendZone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if(userRepository.existsById(user.getUserId())){
            return null;
        } else {
            user.setUserId(user.getEmailId());
            return userRepository.save(new User(user.getFirstName(),
                    user.getLastName(), user.getEmailId()));
        }
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

   @Override
   public User findUser(Integer userId){
        if(userRepository.existsById(userId)){
            return userRepository.getOne(userId);
        } else {
            return null;
        }
   }

    @Override
    public String deleteUser(Integer userId) {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }
}
