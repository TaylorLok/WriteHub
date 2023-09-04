package com.WriteHub.org.WriteHub.Models.Posts;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String slug;
    private int author_id ;
    private int parent_id ;
    private int post_category_id;
    @CreationTimestamp
    @Column( columnDefinition = "DATETIME")
    private Date published_at;
    @UpdateTimestamp
    @Column( columnDefinition = "DATETIME")
    private Date updated_at;
    @CreationTimestamp
    @Column(nullable = false,updatable = false ,  columnDefinition = "DATETIME")
    private Date created_date;

    @Column(columnDefinition = "DATETIME")
    private Date deleted_at;


    public Posts(){

    }
    public Posts(int id, String title, String content, String slug, int author_id, int parent_id, int post_category_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.slug = slug;
        this.author_id = author_id;
        this.parent_id = parent_id;
        this.post_category_id = post_category_id;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getPost_category_id() {
        return post_category_id;
    }

    public void setPost_category_id(int post_category_id) {
        this.post_category_id = post_category_id;
    }

    public Date getPublished_at() {
        return published_at;
    }


    public Date getUpdated_at() {
        return updated_at;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }



}
