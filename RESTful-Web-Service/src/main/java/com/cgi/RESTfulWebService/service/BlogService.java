package com.cgi.RESTfulWebService.service;

import com.cgi.RESTfulWebService.model.Blog;

import java.util.List;

public interface BlogService {
            Blog getBlogById(int blogID);
            Blog addBlog(Blog blog);

            List<Blog> getAllBlogs();

            Blog updateBlog( Blog blog);

           Blog deleteBlog(int blogID);

}
