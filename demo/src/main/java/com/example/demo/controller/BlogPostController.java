package com.example.demo.controller;

import com.example.demo.entity.BlogPost;
import com.example.demo.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class BlogPostController {

    private final BlogPostService blogPostService;

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost>  getPost(@PathVariable Long id) {
        return ResponseEntity.ok(blogPostService.getPost(id));
    }

    @PostMapping
    public  ResponseEntity<BlogPost> addPost(@RequestBody BlogPost post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogPostService.addPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable Long id, @RequestBody BlogPost post) {
        return ResponseEntity.ok(blogPostService.updatePost(id,post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}