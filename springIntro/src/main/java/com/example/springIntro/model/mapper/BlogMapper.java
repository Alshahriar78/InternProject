package com.example.springIntro.model.mapper;

import com.example.springIntro.exception.NotFountException;
import com.example.springIntro.exception.IlligaleException;
import com.example.springIntro.model.dto.BlogDTO;
import com.example.springIntro.model.entity.Blog;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class BlogMapper {

    // UserService ইনজেক্ট করা হয়েছে যাতে ইউজার খোঁজা যায়
    private final UserService userService;

    // DTO থেকে Entity তে রূপান্তরের জন্য মেথড
    public Blog toEntity(BlogDTO dto) throws NotFountException, IlligaleException {
        Blog entity = new Blog();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());

        // ইউজার খোঁজার জন্য authorUserId ব্যবহার করা হয়েছে
        User user = userService.findUserEntityById(dto.getAuthorUserId());

        if (user != null) {
            entity.setAuthor(user);
        } else {
            throw new NotFountException("User not found by id: " + dto.getAuthorUserId());
        }

        // createdAt ফিল্ড ইউজার মডিফাই করলে এক্সেপশন
        if (dto.getCreatedAt() != null) {
            throw new IlligaleException("You are not allowed to modify createdAt");
        } else {
            entity.setCreatedAt(dto.getCreatedAt()); // নতুন ব্লগ তৈরি হলে system তারিখ বসাবে
        }

        // updatedAt ফিল্ড ইউজার মডিফাই করলে এক্সেপশন
        if (dto.getUpdatedAt() != null) {
            throw new IlligaleException("You are not allowed to modify updatedAt");
        } else {
            entity.setUpdatedAt(dto.getUpdatedAt()); // system দ্বারা আপডেট হবে
        }

        return entity;
    }

    // Entity থেকে DTO তে রূপান্তরের জন্য মেথড
    public BlogDTO toDTO(Blog entity) {
        BlogDTO dto = new BlogDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());

        // author এর id DTO তে সেট করা হচ্ছে
        dto.setAuthorUserId(entity.getAuthor().getId());

        // তারিখগুলো টাইমস্ট্যাম্প আকারে রূপান্তর করা হয়েছে
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }
}
