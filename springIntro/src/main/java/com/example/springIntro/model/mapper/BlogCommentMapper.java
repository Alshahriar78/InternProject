package com.example.springIntro.model.mapper;

import com.example.springIntro.model.dto.BlogCommentDTO;
import com.example.springIntro.model.entity.BlogComment;
import org.springframework.stereotype.Component;
@Component
public class BlogCommentMapper {
    public BlogComment map(BlogCommentDTO dto) {
        BlogComment comment = new BlogComment();
        comment.setContent(dto.getContent());
        return comment;
    }
    public BlogCommentDTO map(BlogComment entity) {
        BlogCommentDTO dto = new BlogCommentDTO();
        dto.setContent(entity.getContent());
        return dto;
    }
}


