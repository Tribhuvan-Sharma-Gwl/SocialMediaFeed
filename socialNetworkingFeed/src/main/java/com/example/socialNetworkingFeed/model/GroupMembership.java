package com.example.socialNetworkingFeed.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="group_membership")
@Data
public class GroupMembership {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "group_membership_id")
    private int groupMembershipId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="group_id",referencedColumnName = "id")
    private Group group;
}
