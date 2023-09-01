package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Posts.PostCategories;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostCategoriesRepository extends JpaRepository<PostCategories,Integer> {

    PostCategories findPostCategoriesById(Integer id);
    PostCategories findPostCategoriesByTitle(String title);

    PostCategories findPostCategoriesByDescription(String description);

    PostCategories findPostCategoriesByTitleOrDescription(String title, String description);
}
