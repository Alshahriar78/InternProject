package com.example.springIntro.service;

import com.example.springIntro.exception.IlligaleException;
import com.example.springIntro.exception.NotFountException;
import com.example.springIntro.model.dto.BlogDTO;
import com.example.springIntro.model.entity.Blog;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.model.mapper.BlogMapper;
import com.example.springIntro.repo.BlogRepository;
import com.example.springIntro.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;


@AllArgsConstructor
@Service
public class BlogService {
    private final BlogMapper blogMapper;
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogDTO saveBlog(BlogDTO blogDTO) throws NotFountException, IlligaleException {
        Optional<User> user = userRepository.findById(blogDTO.getAuthorUserId());
        System.out.println("User: " + user);
        if (user.isEmpty()) {
            return null;
        }
        Blog blog = blogMapper.toEntity(blogDTO);
        blog.setAuthor(user.get());
        blogRepository.save(blog);
        return blogMapper.toDTO(blog);
    }

    public BlogDTO getBlogById(Long id) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        return blogOptional.map(blogMapper::toDTO).orElse(null);
    }

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

    public boolean deleteBlog(Long id) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
