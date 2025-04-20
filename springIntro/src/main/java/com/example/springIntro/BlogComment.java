package com.example.springIntro;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_comments")
@Data
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User viewer;

    @Column(nullable = false)
    private String content;

}