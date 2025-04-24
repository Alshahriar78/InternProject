package com.example.springIntro.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Blog> blogPost;

    @OneToMany(mappedBy = "commentator", cascade = CascadeType.ALL)
    private List<BlogComment> comments;

    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private Set<UserRole> userRole;
}
