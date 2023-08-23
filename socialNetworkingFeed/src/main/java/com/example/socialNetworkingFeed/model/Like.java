package com.example.socialNetworkingFeed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="like")
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="post_id",referencedColumnName = "id")
    private Post post;
}
