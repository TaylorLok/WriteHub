package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts , Integer> {

    Posts findPostById(Integer id);

}
