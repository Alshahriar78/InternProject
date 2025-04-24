package com.example.springIntro.model.mapper;

import com.example.springIntro.exception.NotFountException;
import com.example.springIntro.exception.IlligaleException;
import com.example.springIntro.model.dto.BlogDTO;
import com.example.springIntro.model.entity.Blog;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.repo.UserRepository;
import com.example.springIntro.service.BlogService;
import com.example.springIntro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BlogMapper {

    // UserService ইনজেক্ট করা হয়েছে যাতে ইউজার খোঁজা যায়
    private final UserService userService;
    private  final UserRepository userRepository;
//    private final BlogService blogService;

    // DTO থেকে Entity তে রূপান্তরের জন্য মেথড
    public Blog toEntity(BlogDTO dto) throws NotFountException, IlligaleException {
        Blog entity = new Blog();

        //entity.setId(dto.getAuthorUserId() != null ? dto.getAuthorUserId() : null);
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());

        Optional<User> user =userRepository.findById (dto.getAuthorUserId());
        if (user.isEmpty()) {
            return null;
        }
        entity.setAuthor(user.get());
        return entity;
    }

    public BlogDTO toDTO(Blog entity) {
        BlogDTO dto = new BlogDTO();


        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setAuthorUserId(entity.getAuthor().getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        System.out.println(dto);

        return dto;
    }
}

