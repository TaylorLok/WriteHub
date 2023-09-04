package com.WriteHub.org.WriteHub.Models.Tag;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(columnDefinition = "Text")
    private String description;
    @CreationTimestamp
    @Column(nullable = false,updatable = false,columnDefinition = "DATETIME")
    private Date created_at;
    @UpdateTimestamp
    @Column(columnDefinition = "DATETIME")
    private Date updated_at;

    public Tag() {
    }

    public Tag(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
