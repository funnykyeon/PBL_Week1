package com.spring.week1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private String title;
    private String writer;
    private String contents;
}
