package com.example.demo.service;

import com.example.demo.entity.BlogPost;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final AuthorRepository authorRepository;

    public BlogPost getPost(Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public BlogPost addPost(BlogPost post) {
        return blogPostRepository.save(post);
    }

    public BlogPost updatePost(Long id, BlogPost updated) {
        BlogPost post = getPost(id);
        post.setTitle(updated.getTitle());
        post.setPost(updated.getPost());
        post.setAuthor(updated.getAuthor());
        return blogPostRepository.save(post);
    }

    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }
}