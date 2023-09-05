package com.WriteHub.org.WriteHub.Controller;

import com.WriteHub.org.WriteHub.Repository.CommentRepository;
import com.WriteHub.org.WriteHub.Models.Comments.Comment;
import com.WriteHub.org.WriteHub.Models.Users.User;
import com.WriteHub.org.WriteHub.Models.Posts.Post;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepositoryInterface;

    @PostMapping("/add")
    public String addPost(@RequestPart int id, @RequestPart String text, @RequestPart User user_id, @RequestPart Post post_id, @RequestPart Date created_at, @RequestPart Date updated_at, @RequestPart Date deleted_at) {
        Comment comment = new Comment();
        
        comment.setId(id);
        comment.setText(text); 
        comment.setUser_id(user_id);
        comment.setPost_id(post_id);  
        comment.setCreated_at(created_at);
        comment.setUpdated_at(updated_at);
        comment.setDeleted_at(deleted_at);
        
        return "Added new comment";
    }

    @GetMapping("/list")
    public Iterable<Comment> getcomments(){
        return commentRepositoryInterface.findAll();
    }

    @GetMapping("/find/{id}")
    public Comment findPostById(@PathVariable Integer id){
        return commentRepositoryInterface.findPostById(id);
    }
}
