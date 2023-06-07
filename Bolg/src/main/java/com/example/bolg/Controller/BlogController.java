package com.example.bolg.Controller;

import com.example.bolg.Model.Blog;
import com.example.bolg.Model.MyUser;
import com.example.bolg.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;


    @GetMapping("/getBlog")
    public ResponseEntity getBlog(@AuthenticationPrincipal MyUser myUser) {
        List<Blog> blogList = blogService.getAllUsers(myUser.getId());
        return ResponseEntity.status(200).body(blogList);
    }

    @PostMapping("/addBlog")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog) {
        blogService.addBlog(myUser.getId(), blog);
        return ResponseEntity.status(200).body("blog Added");
    }

    @PutMapping("/updateBlog/{blogId}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog, @PathVariable Integer blogId) {
        blogService.updateBlog(myUser.getId(), blog, blogId);
        return ResponseEntity.status(200).body("blog Update it");
    }

    @GetMapping("/getBlogTitle/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title) {
        blogService.getBlogByTitle(title);
        return ResponseEntity.status(200).body("blog found It");
    }

    @DeleteMapping("/deleteBlog/{todoId}")
    public ResponseEntity deleteTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blogId) {
        blogService.deleteBlog(myUser.getId(), blogId);
        return ResponseEntity.status(200).body("Blog deleted ");


    }

    @PostMapping("/assign/{userId}/{blogId}")
    public ResponseEntity addBlog(@PathVariable Integer userId, Integer blogId) {
        blogService.assignUserToBlog(userId, blogId);
        return ResponseEntity.status(200).body("blog Assigned");
    }
}
