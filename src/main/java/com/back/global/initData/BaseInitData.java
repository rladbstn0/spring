package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;
    private int callCount = 0;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            work1();
            work2();

            callCount++;
        };
    }

    void work1() {
        if (postService.count() > 0) return;

        Post post1 = postService.save(new Post("제목1", "내용1")); // INSERT INTO post SET title = '제목 1';

        Post post2 = postService.save(new Post("제목2", "내용2"));

        System.out.println("기본 데이터가 초기화되었습니다.");

//            postRepository.count(); //SELECT count(*) FROM post;
    }
    void work2() {
        Optional<Post> opPost1 = postService.findById(1);
        Post post1 = opPost1.get();

        System.out.println("post1 : "+ post1);
    }
}