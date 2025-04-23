package com.example.springIntro.service;

import com.example.springIntro.exception.IlligaleException;
import com.example.springIntro.exception.NotFountException;
import com.example.springIntro.model.dto.BlogDTO;
import com.example.springIntro.model.entity.Blog;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.model.mapper.BlogMapper;
import com.example.springIntro.repo.BlogRepository;
import com.example.springIntro.repo.UserRepository;
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
    public String  createBlog(BlogDTO blogDTO) throws NotFountException, IlligaleException {

            Optional<User> user = userRepository.findById(blogDTO.getAuthorUserId());
            if(user.isEmpty()){
                return null;
            }
//            if(!roleService.isCreateBlogAccessAuthority(blogDTO.getAuthorUserId()));
//            return  "You are not allowed to create a blog";

            Blog blog = blogMapper.toEntity(blogDTO);
            blog.setAuthor(user.get());

//            BlogCOmment
            blogRepository.save(blog);
           return "Blog created successfully";
    }

    // ✅ Get All Blogs
    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream()
                .map(blogMapper::toDTO)
                .collect(Collectors.toList());
    }

    // ✅ Get Blog By ID
    public BlogDTO getBlogById(Long id) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        return blogOptional.map(blogMapper::toDTO).orElse(null);
    }

    // ✅ Update Blog
    public BlogDTO updateBlog(Long id, BlogDTO blogDTO) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            Blog blog = blogOptional.get();
            blog.setTitle(blogDTO.getTitle());
            blog.setContent(blogDTO.getContent());
            blog.setUpdatedAt(blogDTO.getUpdatedAt());
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
//
//
//
//
//
//
//
