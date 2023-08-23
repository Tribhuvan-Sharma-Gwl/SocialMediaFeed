package com.example.socialNetworkingFeed.service;

import com.example.socialNetworkingFeed.dto.PostDto;

import java.util.List;

public interface FeedService {
    List<PostDto> getAllFeed(int userId);
    List<PostDto> getAllFeedByGroupId(int userId,int groupId);
}
