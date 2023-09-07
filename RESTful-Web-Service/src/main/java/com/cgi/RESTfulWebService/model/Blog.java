package com.cgi.RESTfulWebService.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_id")
    private int blogID;

    @Column(name="blog_title")
    private String blogTitle;

    @Column(name="author_name")
    private String authorName;

    @Column(name="blog_content")
    private String blogContent;

    public Blog(String blogTitle, String authorName, String blogContent) {
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.blogContent = blogContent;
    }
}
