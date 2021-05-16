package org.example.FriendZone.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friends")
public class Friend implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @Id
    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User friend;

//    @ManyToOne
//    @JoinColumn(name="id")
//    private User user;

    public Friend(){};


}
