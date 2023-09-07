package com.cgi.RESTfulWebService.repository;

import com.cgi.RESTfulWebService.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
