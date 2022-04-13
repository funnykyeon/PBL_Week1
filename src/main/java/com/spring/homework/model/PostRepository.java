package com.spring.homework.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    //    @Query("SELECT p FROM Post p WHERE p.title = ?1 or p.contents = ?1 or p.writer = ?1")
    List<Post> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);

}
