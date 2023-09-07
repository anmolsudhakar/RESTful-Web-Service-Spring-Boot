package com.cgi.RESTfulWebService.service;
import com.cgi.RESTfulWebService.model.Blog;
import com.cgi.RESTfulWebService.repository.BlogRepository;
import com.cgi.RESTfulWebService.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    @Autowired
    private final BlogRepository blogRepository;
    @Override
    public Blog getBlogById(int blogID) {
        return blogRepository.findById(blogID).orElse(null);
    }

    @Override
    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog updateBlog( Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog deleteBlog(int blogID) {
        if (!blogRepository.existsById(blogID)) {
            return null;
        }
        Optional<Blog> blog = blogRepository.findById(blogID);
        blogRepository.deleteById(blogID);
        return blog.get();
    }
}
