package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Posts.Posts;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Posts , Integer> {

    Posts findPostById(Integer id);
}
