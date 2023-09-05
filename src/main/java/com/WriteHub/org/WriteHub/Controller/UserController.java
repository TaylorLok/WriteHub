package com.WriteHub.org.WriteHub.Controller;

import com.WriteHub.org.WriteHub.Repository.UserRepository;
import com.WriteHub.org.WriteHub.Models.Users.User;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepositoryInterface;

    @PostMapping("/add")
    public String addPost(@RequestPart int id, @RequestPart String username, @RequestPart String email, @RequestPart String password, @RequestPart Date created_at, @RequestPart Date updated_at, @RequestPart Date deleted_at) {
        User user = new User();
        
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);    
        user.setCreated_at(created_at);
        user.setUpdated_at(updated_at);
        user.setDeleted_at(deleted_at);
        
        return "Added new User";
    }

    @GetMapping("/list")
    public Iterable<User> getUsers(){
        return userRepositoryInterface.findAll();
    }

    @GetMapping("/find/{id}")
    public User findPostById(@PathVariable Integer id){
        return userRepositoryInterface.findPostById(id);
    }
}
