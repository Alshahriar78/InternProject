package com.example.springIntro.model.mapper;

import com.example.springIntro.exception.NotFountException;
import com.example.springIntro.exception.IlligaleException;
import com.example.springIntro.model.dto.BlogDTO;
import com.example.springIntro.model.entity.Blog;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.service.BlogService;
import com.example.springIntro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class BlogMapper {

    // UserService ইনজেক্ট করা হয়েছে যাতে ইউজার খোঁজা যায়
    private final UserService userService;
//    private final BlogService blogService;

    // DTO থেকে Entity তে রূপান্তরের জন্য মেথড
    public Blog toEntity(BlogDTO dto) throws NotFountException, IlligaleException {
        Blog entity = new Blog();

        entity.setId(dto.getAuthorUserId() != null ? dto.getAuthorUserId() : null);
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());

        User user = userService.findUserEntityById(dto.getAuthorUserId());
        if (user != null) {
            entity.setAuthor(user);
        } else {
            throw new NotFountException("User not found by id: " + dto.getAuthorUserId());
        }

        // For new blog posts
        if (dto.getAuthorUserId() == null) {
            LocalDateTime now = LocalDateTime.now();
            entity.setCreatedAt(now);
            entity.setUpdatedAt(now);
        }
        // For existing blog posts
//        else {
//            Blog existingBlog = blogService.findUserEntityById(dto.getId());
//            if (existingBlog != null) {
//                entity.setCreatedAt(existingBlog.getCreatedAt()); // Preserve original creation date
//                entity.setUpdatedAt(LocalDateTime.now()); // Update the modification date
//            }
//        }

        return entity;
    }

    public BlogDTO toDTO(Blog entity) {
        BlogDTO dto = new BlogDTO();


        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setAuthorUserId(entity.getAuthor().getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }
}

