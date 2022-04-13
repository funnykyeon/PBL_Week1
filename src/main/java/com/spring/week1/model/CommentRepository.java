package com.spring.week1.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
//    @Query("SELECT c FROM Comment c WHERE c.postid = ?1")
    List<Comment> findAllByPostidOrderByModifiedAtDesc(String query);
//    findByPostId

    @Query("SELECT c FROM Comment c")
    List<CommentsContentsOnly> findContents();

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("DELETE FROM Comment c WHERE c.postid = ?1")
    void deleteCommentByPostId(String query);

//    List<Comment> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
}
