package com.example.springIntro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogMapper blogMapper;
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogService(BlogMapper blogMapper, BlogRepository blogRepository, UserRepository userRepository) {
        this.blogMapper = blogMapper;
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    // ✅ Create Blog
    public BlogDTO createBlog(Long id, BlogDTO blogDTO) {
        System.out.println(blogDTO);
        Blog blog = blogMapper.toEntity(blogDTO);
        User bloguser= userRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found with id: " + id)); // find author from user table
        blog.setAuthor(bloguser);// set author from user table
        Blog savedBlog = blogRepository.save(blog);
        return blogMapper.toDTO(savedBlog);
    }

    // ✅ Get All Blogs
    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream()
                .map(blogMapper::toDTO)
                .collect(Collectors.toList());
    }

//    // ✅ Get Blog By ID
//    public BlogDTO getBlogById(Long id) {
//        Optional<Blog> blogOptional = blogRepository.findById(id);
//        return blogOptional.map(blogMapper::toEntity).orElse(null);
//    }

    // ✅ Update Blog
    public BlogDTO updateBlog(Long id, BlogDTO blogDTO) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            Blog blog = blogOptional.get();
            blog.setTitle(blogDTO.getTitle());
            blog.setContent(blogDTO.getContent());
            Blog updatedBlog = blogRepository.save(blog);
            return blogMapper.toDTO(updatedBlog);
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







