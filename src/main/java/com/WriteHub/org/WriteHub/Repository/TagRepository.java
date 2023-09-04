package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    Tag findTagById(Integer id);
}
