package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void modify(Post post, String title, String content) {
        boolean changed = false;

        post.setTitle(title);

        if( !post.getTitle().equals(title) ) {
            post.setTitle(title);
            changed = true;
        }

        post.setContent(content);

        if( !post.getContent().equals(content) ) {
            post.setContent(content);
            changed = true;
        }

        if(changed) post.setModifyDate(LocalDateTime.now());

        postRepository.save(post); //UPDATE post SET title = "", content = "", modify_date = "" WHERE id = "";
    }

    public Post write(String title, String content) {
        Post post = new Post(title, content);
        postRepository.save(post);

        return post;
    }
}
