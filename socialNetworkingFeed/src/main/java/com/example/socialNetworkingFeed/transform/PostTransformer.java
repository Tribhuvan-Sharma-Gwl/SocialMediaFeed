package com.example.socialNetworkingFeed.transform;

import com.example.socialNetworkingFeed.dto.PostDto;
import com.example.socialNetworkingFeed.model.Group;
import com.example.socialNetworkingFeed.model.Post;
import com.example.socialNetworkingFeed.model.User;
import com.example.socialNetworkingFeed.repo.GroupRepo;
import com.example.socialNetworkingFeed.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostTransformer {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GroupRepo groupRepo;
    public Post transform(PostDto postDto){
        User user = userRepo.findById((long) (postDto.getUserId())).get();
        Group group= groupRepo.findById((long)(postDto.getGroupId())).get();
        Post post= new Post(postDto.getId(),user,group, postDto.getContent());
        return post;
    }
    public PostDto reverseTransform(Post post){
        PostDto postDto = new PostDto(post.getId(),post.getUser().getId(),post.getGroup().getId(),post.getContent());
        return postDto;
    }
}
