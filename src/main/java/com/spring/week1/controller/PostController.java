package com.spring.week1.controller;

import com.spring.week1.model.CommentRepository;
import com.spring.week1.model.Post;
import com.spring.week1.model.PostDto;
import com.spring.week1.model.PostRepository;
import com.spring.week1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postservice;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @GetMapping("/api/posts")
    public List<Post> getPosts(){
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return postRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

//    @GetMapping("/api/posts/search/{query}")
//    public List<Post> searchPosts(@PathVariable String query){
//        System.out.println(query);
//        return postRepository.findByTitleOrContentsOrWriter(query);
//    }

    @PostMapping("/api/posts")
    public Post createProduct(@RequestBody PostDto postDto) {
        System.out.println(postDto.getTitle());
        Post product = new Post(postDto);
        postRepository.save(product);
        return product;
    }
    // 설정 가격 변경
    @PutMapping("/api/posts/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody PostDto postDto) {
        System.out.println(postDto);
        return postservice.update(id, postDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        postRepository.deleteById(id);
        commentRepository.deleteCommentByPostId(id.toString());
        return id;
    }
}
