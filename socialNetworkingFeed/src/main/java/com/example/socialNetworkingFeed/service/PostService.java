package com.example.socialNetworkingFeed.service;

import com.example.socialNetworkingFeed.dto.PostDto;
import com.example.socialNetworkingFeed.model.Comment;
import com.example.socialNetworkingFeed.model.Like;

public interface PostService {
    PostDto groupPost(PostDto postDto);

    Like likePost(int postId, int userId);

    Comment commentPost(int postId, int userId , String content);

    //Like likePost(PostDto postDto);
}
