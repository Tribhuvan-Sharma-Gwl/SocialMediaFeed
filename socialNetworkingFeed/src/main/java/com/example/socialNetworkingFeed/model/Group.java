package com.example.socialNetworkingFeed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name= "group_name")
    private String groupName;


}
