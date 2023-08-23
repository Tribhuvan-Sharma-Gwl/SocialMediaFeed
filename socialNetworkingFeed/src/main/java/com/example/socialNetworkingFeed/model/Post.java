package com.example.socialNetworkingFeed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="post")
@Data
public class Post {
    public Post( User user, Group group) {
        this.user = user;
        this.group = group;
    }

    public Post(int id, User user, Group group, String content) {
        this.id = id;
        this.user = user;
        this.group = group;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="group_id",referencedColumnName = "id")
    private Group group;

    @Column(name="content")
    private String content;

}
