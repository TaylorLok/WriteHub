package com.WriteHub.org.WriteHub.Controller;

import com.WriteHub.org.WriteHub.Repository.PostRepository;
import com.WriteHub.org.WriteHub.Models.Posts.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepositoryInterface;

    @PostMapping("/add")
    public String addPost(@RequestPart String title ,@RequestPart String content , @RequestPart String slug , @RequestPart Integer author_id ,  @RequestPart Integer parent_id , @RequestPart Integer post_category_id){
        Posts post = new Posts();
        post.setTitle(title);
        post.setContent(content);
        post.setSlug(slug);
        post.setAuthor_id(author_id);
        post.setParent_id(parent_id);
        post.setPost_category_id(post_category_id);
        return "Added new post";
    }

    @GetMapping("/list")
    public Iterable<Posts> getPosts(){
        return postRepositoryInterface.findAll();
    }

    @GetMapping("/find/{id}")
    public Posts findPostById(@PathVariable Integer id){
        return postRepositoryInterface.findPostById(id);
    }


}
