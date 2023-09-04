package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostById(Integer id);

}
