package com.example.socialNetworkingFeed.repo;

import com.example.socialNetworkingFeed.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
}
