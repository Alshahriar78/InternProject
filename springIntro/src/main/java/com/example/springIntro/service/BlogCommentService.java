package com.example.springIntro.service;

import com.example.springIntro.model.dto.BlogCommentDTO;
import com.example.springIntro.model.entity.Blog;
import com.example.springIntro.model.entity.BlogComment;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.model.mapper.BlogCommentMapper;
import com.example.springIntro.repo.BlogCommentRepository;
import com.example.springIntro.repo.BlogRepository;
import com.example.springIntro.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class BlogCommentService {

    private final BlogCommentRepository blogCommentRepository;
    private final BlogCommentMapper blogCommentMapper;
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;





    //     Create a new comment
    public BlogCommentDTO createComment(BlogCommentDTO blogcommentDTO  ) {
        BlogComment comment = blogCommentMapper.toEntity(blogcommentDTO);
        User user= userRepository.findById(blogcommentDTO.getCommentator()).orElseThrow();
        comment.setCommentator(user);
        Blog blog= blogRepository.findById(blogcommentDTO.getBlogId()).orElseThrow();
        comment.setBlogEntity(blog);
        blogCommentRepository.save(comment);

        return blogcommentDTO;
    }
//
//    // Get all comments
//    public List<BlogCommentDTO> getAllComments() {
//        return blogCommentRepository.findAll()
//                .stream()
//                .map(blogCommentMapper::map)
//                .collect(Collectors.toList());
//    }
//
//    // Get comment by ID
//    public Optional<BlogCommentDTO> getCommentById(Long id) {
//        return blogCommentRepository.findById(id)
//                .map(blogCommentMapper::map);
//    }
//
//    // Update comment
//    public Optional<BlogCommentDTO> updateComment(Long id, BlogCommentDTO updatedDTO) {
//        return blogCommentRepository.findById(id).map(existing -> {
//            existing.setContent(updatedDTO.getContent());
//            BlogComment updated = blogCommentRepository.save(existing);
//            return blogCommentMapper.map(updated);
//        });
//    }
//
//    // Delete comment
//    public boolean deleteComment(Long id) {
//        if (blogCommentRepository.existsById(id)) {
//            blogCommentRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
}
