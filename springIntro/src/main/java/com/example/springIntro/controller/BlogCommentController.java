package com.example.springIntro.controller;

import com.example.springIntro.model.dto.BlogCommentDTO;
import com.example.springIntro.model.dto.BlogDTO;
import com.example.springIntro.service.BlogCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog/comment")
public class BlogCommentController {

    private final BlogCommentService blogCommentService;

    public BlogCommentController(BlogCommentService blogCommentService) {
        this.blogCommentService = blogCommentService;
    }

    // Create a new comment
    @PostMapping("/postComments")
    public ResponseEntity<BlogCommentDTO> createComment(@RequestBody BlogCommentDTO commentDTO ) {
        BlogCommentDTO savedComment = blogCommentService.createComment(commentDTO);
        return ResponseEntity.ok(savedComment);
    }

//    // Get all comments
//    @GetMapping("/getAll")
//    public ResponseEntity<List<BlogCommentDTO>> getAllComments() {
//        List<BlogCommentDTO> comments = blogCommentService.getAllComments();
//        return ResponseEntity.ok(comments);
//    }
//
//    // Get comment by ID
//    @GetMapping("api/v1/blog/comment/get/{id}")
//    public ResponseEntity<BlogCommentDTO> getCommentById(@PathVariable Long id) {
//        return blogCommentService.getCommentById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Delete comment by ID
//    @DeleteMapping("api/v1/blog/comment/delete/{id}")
//    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
//        blogCommentService.deleteComment(id);
//        return ResponseEntity.ok("Comment deleted successfully.");
//    }
}
