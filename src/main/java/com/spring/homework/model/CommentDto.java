package com.spring.homework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private String postid;
    private String writer;
    private String contents;
}
