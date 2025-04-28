package com.example.springIntro.model.mapper;

import com.example.springIntro.model.dto.BlogCommentDTO;
import com.example.springIntro.model.entity.BlogComment;
import org.springframework.stereotype.Component;
@Component
public class BlogCommentMapper {
    public BlogComment toEntity(BlogCommentDTO dto) {
        BlogComment comment = new BlogComment();
        comment.setContent(dto.getContent());


        return comment;
    }
    public BlogCommentDTO toDTO(BlogComment entity) {
        BlogCommentDTO dto = new BlogCommentDTO();
        dto.setContent(entity.getContent());
        dto.setBlogId(entity.getBlogEntity().getId());
        dto.setCommentator(entity.getCommentator().getId());
        return dto;
    }
}


