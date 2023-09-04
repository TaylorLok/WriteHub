package com.WriteHub.org.WriteHub.Controller;

import com.WriteHub.org.WriteHub.Models.Post.PostCategory;
import com.WriteHub.org.WriteHub.Repository.PostCategoryRepository;
import com.WriteHub.org.WriteHub.Repository.PostRepository;
import com.WriteHub.org.WriteHub.Models.Post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository postRepositoryInterface;
    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @PostMapping("/create/{post_category_id}")
    public String addPost(@RequestBody Map<String, String> requestPayload , @PathVariable int post_category_id) {
        String title = requestPayload.get("title");
        String content = requestPayload.get("content");
        String slug = requestPayload.get("slug");

        // Check to see if post_category_id exists in database
       PostCategory postCategoryById =  postCategoryRepository.findPostCategoriesById(post_category_id);

        //If not then throw Bad Request Error
        if (postCategoryById == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect post category ID");
        }
        //Creates a new instance of Posts and populate it with the payload data
        Post post = new Post();
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
    public Iterable<Post> getPosts(){
        return postRepositoryInterface.findAll();
    }

    @GetMapping("/find/{id}")
    public Post findPostById(@PathVariable Integer id) {
        //Find post by the provided id
        Post post = postRepositoryInterface.findPostById(id);
        Date getPostDeleted_at = post.getDeleted_at();

        if (getPostDeleted_at != null) {
            throw new ResponseStatusException(HttpStatus.OK, "No matching ID found");
        }
        return post;
    }

    @PostMapping ("/delete/{id}")
    public Post deletePostById(@PathVariable Integer id) {
        //Find post by the provided id
        Post post = postRepositoryInterface.findPostById(id);

        if (post == null) {
            throw new ResponseStatusException(HttpStatus.OK, "No matching ID found");
        }
            post.setDeleted_at(new Date());
            postRepositoryInterface.save(post);
//        postRepositoryInterface.delete(post);
        throw new ResponseStatusException(HttpStatus.OK , "Post "+id+" Deleted");
    }

}
