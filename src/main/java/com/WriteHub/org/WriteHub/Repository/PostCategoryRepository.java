package com.WriteHub.org.WriteHub.Repository;

import com.WriteHub.org.WriteHub.Models.Post.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostCategoryRepository extends JpaRepository<PostCategory,Integer> {

    PostCategory findPostCategoriesById(Integer id);
    PostCategory findPostCategoriesByTitle(String title);

    PostCategory findPostCategoriesByDescription(String description);

    PostCategory findPostCategoriesByTitleOrDescription(String title, String description);
}
