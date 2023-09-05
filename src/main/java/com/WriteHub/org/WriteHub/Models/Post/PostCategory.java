package com.WriteHub.org.WriteHub.Models.Post;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class PostCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @CreationTimestamp
    @Column(nullable = false,updatable = false, columnDefinition = "DATETIME")

    private Date created_at;
    @UpdateTimestamp
    @Column(columnDefinition = "DATETIME")
    private  Date updated_at;


    public PostCategory() {
    }
    public PostCategory(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId(Integer post_category_id) {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
