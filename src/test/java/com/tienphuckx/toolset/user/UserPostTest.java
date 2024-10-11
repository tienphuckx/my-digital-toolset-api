package com.tienphuckx.toolset.user;

import com.tienphuckx.toolset.entity.post.Post;
import com.tienphuckx.toolset.entity.user.User;
import com.tienphuckx.toolset.repository.PostRepository;
import com.tienphuckx.toolset.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserPostTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void one_to_many_test() {
        // Create a new user
        User user = new User();
        user.setUserName("John Wick");
        user.setUserEmail("john@wick.com");
        user.setUserPhone("091834734");
        user.setUserPassword("*********");

        // Create two posts
        Post post1 = new Post();
        post1.setTitle("Dangling Pointer in C++");
        post1.setDescription("DESC: Dangling Pointer in C++");

        Post post2 = new Post();
        post2.setTitle("Memory Leaks in C++");
        post2.setDescription("DESC: Memory Leaks in C++");

        // Add posts to the user
        post1.setUser(user);
        post2.setUser(user);

        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        user.setPosts(posts);

        // Save the user (posts will be automatically saved due to cascading)
        userRepository.save(user);

        // Assertions
        User savedUser = userRepository.findById(user.getId()).orElse(null);
        assertNotNull(savedUser);
        assertEquals("John Wick", savedUser.getUserName());
        assertEquals(2, savedUser.getPosts().size());

        Post savedPost1 = savedUser.getPosts().get(0);
        Post savedPost2 = savedUser.getPosts().get(1);
        assertNotNull(savedPost1);
        assertNotNull(savedPost2);
        assertEquals("Dangling Pointer in C++", savedPost1.getTitle());
        assertEquals("Memory Leaks in C++", savedPost2.getTitle());
    }



    //TEST only save user but it also save POST
    @Test
    @Transactional
    @Rollback(value = false)
    void one_to_many_test_only_save_user() {
        // Create a new user
        User user = new User();
        user.setUserName("Tom");
        user.setUserEmail("tom@.com");
        user.setUserPhone("091834734");
        user.setUserPassword("*********");

        // Create two posts
        Post post1 = new Post();
        post1.setTitle("The end is near");
        post1.setDescription("DESC: The end is near");

        Post post2 = new Post();
        post2.setTitle("C pointer");
        post2.setDescription("DESC: C pointer");

        // Add posts to the user
        post1.setUser(user);
        post2.setUser(user);

        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        user.setPosts(posts);

        // Save the user (posts will be automatically saved due to cascading)
        userRepository.save(user);

    }
}
