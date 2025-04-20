package com.example.springIntro;

import com.example.springIntro.BlogCommentDTO;
import com.example.springIntro.BlogComment;
import com.example.springIntro.BlogCommentMapper;
import com.example.springIntro.BlogCommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogCommentService {

    private final BlogCommentRepository blogCommentRepository;
    private final BlogCommentMapper blogCommentMapper;

    public BlogCommentService(BlogCommentRepository commentRepository, BlogCommentMapper commentMapper) {
        this.blogCommentRepository = commentRepository;
        this.blogCommentMapper = commentMapper;
    }

    // Create a new comment
    public BlogCommentDTO createComment(BlogCommentDTO blogcommentDTO) {
        BlogComment comment = blogCommentMapper.map(blogcommentDTO);

        return blogCommentRepository.save(comment);
    }

    // Get all comments
    public List<BlogCommentDTO> getAllComments() {
        return blogCommentRepository.findAll()
                .stream()
                .map(blogCommentMapper::map)
                .collect(Collectors.toList());
    }

    // Get comment by ID
    public Optional<BlogCommentDTO> getCommentById(Long id) {
        return blogCommentRepository.findById(id)
                .map(blogCommentMapper::map);
    }

    // Update comment
    public Optional<BlogCommentDTO> updateComment(Long id, BlogCommentDTO updatedDTO) {
        return blogCommentRepository.findById(id).map(existing -> {
            existing.setContent(updatedDTO.getContent());
            BlogComment updated = blogCommentRepository.save(existing);
            return blogCommentMapper.map(updated);
        });
    }

    // Delete comment
    public boolean deleteComment(Long id) {
        if (blogCommentRepository.existsById(id)) {
            blogCommentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
