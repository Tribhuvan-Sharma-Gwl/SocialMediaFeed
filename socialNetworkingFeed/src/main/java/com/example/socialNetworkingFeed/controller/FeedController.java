package com.example.socialNetworkingFeed.controller;

import com.example.socialNetworkingFeed.dto.PostDto;
import com.example.socialNetworkingFeed.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedController {
    @Autowired
    private FeedService feedService;

    @GetMapping("/{userId}")
    public List<PostDto> getAllFeed(@PathVariable("userId") int userId){
        return feedService.getAllFeed(userId);
    }
    @GetMapping("/groups/{groupId}/user/{userId}")
    public List<PostDto> getAllFeed(@PathVariable("userId") int userId, @PathVariable("groupId") int groupId){
        return feedService.getAllFeedByGroupId(userId, groupId);
    }

}
