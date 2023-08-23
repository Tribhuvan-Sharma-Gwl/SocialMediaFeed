package com.example.socialNetworkingFeed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="comment")
@Data
public class Comment {
    public Comment(User user, Post post, String content) {
        this.user = user;
        this.post = post;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="post_id",referencedColumnName = "id")
    private Post post;

    @Column(name="content")
    private String content;
}
