package com.WriteHub.org.WriteHub.Controller;

import com.WriteHub.org.WriteHub.Models.Posts.PostCategories;
import com.WriteHub.org.WriteHub.Repository.PostCategoriesRepository;
import com.WriteHub.org.WriteHub.Repository.PostRepository;
import com.WriteHub.org.WriteHub.Models.Posts.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository postRepositoryInterface;
    @Autowired
    private  PostCategoriesRepository postCategoriesRepository;

    @PostMapping("/create/{post_category_id}")
    public String addPost(@RequestBody Map<String, String> requestPayload , @PathVariable int post_category_id) {
        String title = requestPayload.get("title");
        String content = requestPayload.get("content");
        String slug = requestPayload.get("slug");

        // Check to see if post_category_id exists in database
       PostCategories postCategoriesById =  postCategoriesRepository.findPostCategoriesById(post_category_id);

        //If not then throw Bad Request Error
        if (postCategoriesById == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect post category ID");
        }
        //Creates a new instance of Posts and populate it with the payload data
        Posts post = new Posts();
        post.setTitle(title);
        post.setContent(content);
        post.setSlug(slug);
        post.setAuthor_id(1);
        post.setParent_id(1);
        post.setPost_category_id(post_category_id);
        //Saves the set data to the database
        postRepositoryInterface.save(post);
        //throws success Response
        throw new ResponseStatusException(HttpStatus.OK, "Added new post");

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
