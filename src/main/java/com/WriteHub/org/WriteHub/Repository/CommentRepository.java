package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Comments.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , Integer> {

    Comment findPostById(Integer id);
}
