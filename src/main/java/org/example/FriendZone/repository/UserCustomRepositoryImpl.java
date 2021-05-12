//package org.example.FriendZone.repository;
//
//import org.example.FriendZone.model.User;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//
//@Repository
//public class UserCustomRepositoryImpl implements UserCustomRepository{
//
//
//
//    @Override
//    @Transactional
//    @Modifying(clearAutomatically = true)
////    @Query("UPDATE users u set u.hobbies = :hobbies where u.username = :username")
//    public void addHobbies(User user) {
//        user.setHobbies(user.getHobbies());
//
//        System.out.println("query executed??");
//
//    }
//}
//
////"INSERT INTO users (hobbies) VALUES(?)"
