package com.example.springIntro.controller;

import com.example.springIntro.model.dto.BlogCommentDTO;
import com.example.springIntro.model.dto.BlogDTO;
import com.example.springIntro.service.BlogCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/comments")
public class BlogCommentController {
    private final BlogCommentService blogCommentService;

    public BlogCommentController(BlogCommentService blogCommentService) {
        this.blogCommentService = blogCommentService;
    }

    @PostMapping("/postComments")
    public ResponseEntity<BlogCommentDTO> createComment(@RequestBody BlogCommentDTO commentDTO ) {
        BlogCommentDTO savedComment = blogCommentService.createComment(commentDTO);
        return ResponseEntity.ok(savedComment);
    }

   @GetMapping("/{id}")
    public BlogCommentDTO getCommentById(@PathVariable Long id) {
        BlogCommentDTO getComment = blogCommentService.findCommentByID( id);
        return getComment;
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteComment(@PathVariable Long id) {
        blogCommentService.deleteCommentById(id);
        return Optional.of("Comment deleted successfully with ID: " + id);
    }
    @PatchMapping("/{id}")
    public BlogCommentDTO updateComment(@PathVariable Long id, @RequestBody BlogCommentDTO commentDTO) {
        BlogCommentDTO blogCommentDTO = blogCommentService.updateCommentById(id, commentDTO);
        return blogCommentDTO;
    }
}
