package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer> {

    User findPostById(Integer id);
}
