package com.spring.week1.controller;

import com.spring.week1.model.*;
import com.spring.week1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentservice;
    private final CommentRepository commentRepository;

    @GetMapping("/api/comments/{postid}")
    public List<Comment> getPosts(@PathVariable String postid){
        return commentRepository.findAllByPostidOrderByModifiedAtDesc(postid);
    }
    @GetMapping("/api/comments")
    public List<CommentsContentsOnly> getPosts(){
        return commentRepository.findContents();

    }


    @PostMapping("/api/comments")
    public Comment createProduct(@RequestBody CommentDto commentDto) {
        Comment comment = new Comment(commentDto);
        commentRepository.save(comment);
        return comment;
    }
//    @PostMapping("/api/comments")
//    public Comment createProduct(@RequestBody CommentDto commentDto) {
//        Comment comment = new Comment(commentDto);
//        if (comment.getContents() == ""){
//            comment.setContents("에러났다능!!");
//        }
//        commentRepository.save(comment);
//        return comment;
//
//}

    @PutMapping("/api/comments/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        return commentservice.update(id, commentDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}

