package com.example.socialNetworkingFeed.service.Impl;

import com.example.socialNetworkingFeed.dto.PostDto;
import com.example.socialNetworkingFeed.model.Post;
import com.example.socialNetworkingFeed.repo.PostRepo;
import com.example.socialNetworkingFeed.service.FeedService;
import com.example.socialNetworkingFeed.transform.PostTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FeedServiceImpl implements FeedService {
    private final PostRepo postRepo;
    private final PostTransformer postTransformer;
    public FeedServiceImpl(PostRepo postRepo, PostTransformer postTransformer) {
        this.postRepo = postRepo;
        this.postTransformer = postTransformer;
    }

    @Override
    public List<PostDto> getAllFeed(int userId) {
        List<Post> posts = arrangeFeed(userId);
        List<PostDto>postDtoList = posts.stream().map(postTransformer::reverseTransform).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public List<PostDto> getAllFeedByGroupId(int userId, int groupId) {
        List<Post> posts = arrangeGroupPost(userId,groupId);
        List<PostDto>postDtoList = posts.stream().map(postTransformer::reverseTransform).collect(Collectors.toList());
        return postDtoList;
    }

    private List<Post> arrangeFeed(int userId){
        List<Post> posts = postRepo.findAllPostByUserId(userId);
        return posts;
    }
    private List<Post> arrangeGroupPost(int userId, int groupId){
        List<Post> posts = postRepo.findAllPostByUserIdGroupId(userId, groupId);
        return posts;
    }

}
