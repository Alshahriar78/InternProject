package com.example.springIntro;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogMapper blogMapper;
    private final BlogRepository blogRepository;

    public BlogService(BlogMapper blogMapper, BlogRepository blogRepository) {
        this.blogMapper = blogMapper;
        this.blogRepository = blogRepository;
    }

    // ✅ Create Blog
    public BlogDTO createBlog(BlogDTO blogDTO) {
        Blog blog = blogMapper.map(blogDTO);
        blog.setCreatedAt(new Date());
        blog.setUpdatedAt(new Date());
        Blog savedBlog = blogRepository.save(blog);
        return blogMapper.map(savedBlog);
    }

    // ✅ Get All Blogs
    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream()
                .map(blogMapper::map)
                .collect(Collectors.toList());
    }

    // ✅ Get Blog By ID
    public BlogDTO getBlogById(Long id) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        return blogOptional.map(blogMapper::map).orElse(null);
    }

    // ✅ Update Blog
    public BlogDTO updateBlog(Long id, BlogDTO blogDTO) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            Blog blog = blogOptional.get();
            blog.setTitle(blogDTO.getTitle());
            blog.setContent(blogDTO.getContent());
            blog.setUpdatedAt(new Date());
            Blog updatedBlog = blogRepository.save(blog);
            return blogMapper.map(updatedBlog);
        }
        return null;
    }

    // ✅ Delete Blog
    public boolean deleteBlog(Long id) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}







