package com.example.springIntro;

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


