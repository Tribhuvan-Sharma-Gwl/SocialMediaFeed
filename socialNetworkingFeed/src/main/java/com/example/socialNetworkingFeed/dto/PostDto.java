package com.example.socialNetworkingFeed.dto;

import lombok.Data;

@Data
public class PostDto {
    private int id;
    private int userId;
    private int groupId;

    public PostDto(int id, int userId, int groupId, String content) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
        this.content = content;
    }

    private String content;
}
