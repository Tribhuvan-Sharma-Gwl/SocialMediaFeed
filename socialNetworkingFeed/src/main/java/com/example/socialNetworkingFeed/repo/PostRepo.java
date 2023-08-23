package com.example.socialNetworkingFeed.repo;

import com.example.socialNetworkingFeed.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post,Long> {
    @Query(value = "select * from post where user_id=:userId",nativeQuery= true)
    List<Post> findAllPostByUserId(int userId);
    @Query(value = "select * from post where user_id=:userId and group_id=:groupId",nativeQuery = true)
    List<Post> findAllPostByUserIdGroupId(int userId, int groupId);
}
