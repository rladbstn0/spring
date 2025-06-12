package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }
    public Post save(Post post) {
        return postRepository.save(post);
    }
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }
}
