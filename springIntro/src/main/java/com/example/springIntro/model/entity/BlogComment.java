package com.example.springIntro.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_comments")
@Data
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User commentator;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id")
    private Blog blogEntity;



}