package com.example.socialNetworkingFeed.service.Impl;

import com.example.socialNetworkingFeed.dto.PostDto;
import com.example.socialNetworkingFeed.model.*;
import com.example.socialNetworkingFeed.repo.*;
import com.example.socialNetworkingFeed.service.PostService;
import com.example.socialNetworkingFeed.transform.PostTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private PostTransformer postTransformer;
    @Autowired
    private LikeRepo likeRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Override
    public PostDto groupPost(PostDto postDto) {
       Group group= groupRepo.findById((long) postDto.getGroupId()).get();
       User user = userRepo.findById((long) (postDto.getUserId())).get();
       postDto= postTransformer.reverseTransform(postRepo.save(new Post(user,group)));
       return postDto;
    }

    @Override
    public Like likePost(int postId, int userId) {
        User user= userRepo.findById((long) userId).get();
        Post post= postRepo.findById((long) postId).get();
        Like like= new Like(user,post);
        like=likeRepo.save(like);
        return like;
    }
    @Override
    public Comment commentPost(int postId, int userId , String content) {
        User user= userRepo.findById((long) userId).get();
        Post post= postRepo.findById((long) postId).get();
        Comment comment= new Comment(user,post,content);
        comment = commentRepo.save(comment);
        return comment;
    }
}
