package com.cgi.RESTfulWebService.controller;

import com.cgi.RESTfulWebService.model.Blog;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cgi.RESTfulWebService.service.BlogService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private final BlogService blogService;


    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        var blogs = blogService.getAllBlogs();
        if (blogs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int blogID) {
        var blog = blogService.getBlogById(blogID);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blog);
    }

    @PostMapping
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        var newBlog = blogService.addBlog(blog);
        if (newBlog == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(newBlog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int blogID, @RequestBody Blog blog) {
        if (blogService.getBlogById(blogID) == null) {
            return ResponseEntity.badRequest().build();
        }
        Blog blg = blogService.updateBlog(blog);
        return ResponseEntity.ok(blg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable int blogID) {
        var blog = blogService.deleteBlog(blogID);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blog);
    }
}

