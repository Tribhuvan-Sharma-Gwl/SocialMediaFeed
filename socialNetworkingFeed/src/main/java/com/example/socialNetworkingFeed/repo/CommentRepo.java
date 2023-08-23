package com.example.socialNetworkingFeed.repo;

import com.example.socialNetworkingFeed.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment,Long> {
}
