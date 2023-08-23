package com.example.socialNetworkingFeed.controller;

import com.example.socialNetworkingFeed.dto.PostDto;
import com.example.socialNetworkingFeed.model.Comment;
import com.example.socialNetworkingFeed.model.Like;
import com.example.socialNetworkingFeed.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("/{groupId}")
    public PostDto groupPost(@RequestBody PostDto postDto ){
       return  postService.groupPost(postDto);
    }

    @PostMapping("/{postId}/user/{userId}/like")
    public Like likePost(@PathVariable("postId") int postId, @PathVariable("userId") int userId){
        return  postService.likePost(postId , userId);
    }

    @PostMapping("/{postId}/user/{userId}/comment")
    public Comment commentPost(@PathVariable("postId") int postId, @PathVariable("userId") int userId,@RequestBody String content){
        return  postService.commentPost(postId , userId, content);
    }



}
