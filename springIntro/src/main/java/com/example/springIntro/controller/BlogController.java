package com.example.springIntro.controller;

import com.example.springIntro.exception.IlligaleException;
import com.example.springIntro.exception.NotFountException;
import com.example.springIntro.model.dto.BlogDTO;
import com.example.springIntro.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/create")
    public ResponseEntity<BlogDTO> createBlog( @RequestBody BlogDTO blogDTO) throws NotFountException, IlligaleException {
             System.out.println(blogDTO);
        BlogDTO createdBlog = blogService.saveBlog(blogDTO).getBody();
        return ResponseEntity.ok(createdBlog);

    }
    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Long id) {
        BlogDTO blogDTO = blogService.getBlogById(id);
        return ResponseEntity.ok(blogDTO);
    }



    // ✅ Get all blogs
    @GetMapping("/all")
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        List<BlogDTO> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long id, @RequestBody BlogDTO blogDTO) {
        BlogDTO updatedBlog = blogService.updateBlog(id, blogDTO);
        return ResponseEntity.ok(updatedBlog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully with ID: " + id);
    }


}
