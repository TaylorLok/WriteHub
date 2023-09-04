package com.WriteHub.org.WriteHub.database.seeders;

import com.WriteHub.org.WriteHub.Models.Post.PostCategory;
import com.WriteHub.org.WriteHub.Repository.PostCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @EventListener
    private void seed(ContextRefreshedEvent event){
        seedPostCategory();
    }

    private void seedPostCategory() {
        String[] titles = { "Apples", "Taylor" ,"Money"};
        String[] descriptions = { "Apples are too tasty", "His Gay" ,"I need it!"};

        for (int i = 0; i < titles.length; i++) {
            String title = titles[i];
            String description = descriptions[i];

            // Check if a PostCategory with the same title or description already exists
            PostCategory existingCategory = postCategoryRepository.findPostCategoriesByTitleOrDescription(title, description);

            if (existingCategory == null) {
                // If it doesn't exist, create and save a new PostCategories instance
                PostCategory postCategory = new PostCategory();
                postCategory.setTitle(title);
                postCategory.setDescription(description);
                postCategoryRepository.save(postCategory);
            }
        }
    }

}


