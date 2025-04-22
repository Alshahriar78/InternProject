package com.example.springIntro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("blog/create/{id}")
    public ResponseEntity<BlogDTO> createBlog(@PathVariable Long id ,@RequestBody BlogDTO blogDTO) {
        System.out.println(blogDTO);
        BlogDTO createdBlog = blogService.createBlog(id, blogDTO);
        return ResponseEntity.ok(createdBlog);
    }
//    @GetMapping("api/v1/blog/get/{id}")
//    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Long id) {
//        BlogDTO blogDTO = blogService.getBlogById(id);
//        return ResponseEntity.ok(blogDTO);
//    }



    // ✅ Get all blogs
    @GetMapping("blog/all")
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        List<BlogDTO> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }

    @PutMapping("blog/update/{id}")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long id, @RequestBody BlogDTO blogDTO) {
        BlogDTO updatedBlog = blogService.updateBlog(id, blogDTO);
        return ResponseEntity.ok(updatedBlog);
    }

    @DeleteMapping("blog/delete/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully with ID: " + id);
    }


}
