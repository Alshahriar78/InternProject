package com.example.springIntro.service;

import com.example.springIntro.model.dto.BlogCommentDTO;
import com.example.springIntro.model.entity.Blog;
import com.example.springIntro.model.entity.BlogComment;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.model.mapper.BlogCommentMapper;
import com.example.springIntro.repo.BlogCommentRepository;
import com.example.springIntro.repo.BlogRepository;
import com.example.springIntro.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BlogCommentService {

    private final BlogCommentRepository blogCommentRepository;
    private final BlogCommentMapper blogCommentMapper;
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;

    public BlogCommentDTO createComment(BlogCommentDTO blogcommentDTO  ) {
        BlogComment comment = blogCommentMapper.toEntity(blogcommentDTO);
        User user= userRepository.findById(blogcommentDTO.getCommentator()).orElseThrow();
        comment.setCommentator(user);
        Blog blog= blogRepository.findById(blogcommentDTO.getBlogId()).orElseThrow();
        comment.setBlogEntity(blog);
        blogCommentRepository.save(comment);
        return blogcommentDTO;
    }

    public BlogCommentDTO findCommentByID(Long id){
        BlogComment blogComment = blogCommentRepository.findById(id).orElseThrow();
        return blogCommentMapper.toDTO(blogComment);

    }

    public void deleteCommentById(Long id) {
        if (!blogCommentRepository.existsById(id)) {
            throw new RuntimeException("Comment not found with id: " + id);
        }
        blogCommentRepository.deleteById(id);
    }

    public BlogCommentDTO updateCommentById(Long id, BlogCommentDTO commentDTO) {

        BlogComment existingComment = blogCommentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
        if (commentDTO.getContent() != null) {
            existingComment.setContent(commentDTO.getContent());
        }
        if (commentDTO.getBlogId() != null) {
            Blog blog = blogRepository.findById(commentDTO.getBlogId())
                    .orElseThrow(() -> new RuntimeException("Blog not found with id: " + commentDTO.getBlogId()));
            existingComment.setBlogEntity(blog);
        }
        if (commentDTO.getCommentator() != null) {
            User user = userRepository.findById(commentDTO.getCommentator())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + commentDTO.getCommentator()));
            existingComment.setCommentator(user);
        }
        BlogComment updatedComment = blogCommentRepository.save(existingComment);
        return blogCommentMapper.toDTO(updatedComment);
    }
}
