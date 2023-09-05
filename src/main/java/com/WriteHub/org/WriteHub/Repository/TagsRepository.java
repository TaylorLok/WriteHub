package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Tags.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Integer> {

    Tags findTagById(Integer id);
}
