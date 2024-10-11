package com.tienphuckx.toolset.repository;
import com.tienphuckx.toolset.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
