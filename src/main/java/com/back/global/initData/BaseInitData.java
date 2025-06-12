package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    @Autowired
    @Lazy
    private BaseInitData self;
    private final PostService postService;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work1();
            self.work2();

            new Thread(()->self.work3()).start();
        };
    }

    @Transactional
    void work1() {
        if (postService.count() > 0) return;

        Post post1 = new Post("제목 1", "내용 1"); // INSERT INTO post SET title = '제목 1';
        postService.save(post1);
        Post post2 = postService.save(new Post("제목 2", "내용 2"));

        System.out.println("기본 데이터가 초기화되었습니다.");

//            postRepository.count(); //SELECT count(*) FROM post;
    }

    @Transactional(readOnly = true)
    void work2() {
        Optional<Post> opPost1 = postService.findById(1);
        Post post1 = opPost1.get();

        System.out.println("post1 : "+ post1);
    }

    @Transactional
    void work3() {
        Optional<Post> opPost1 = postService.findById(1);
        Post post1 = opPost1.get();

//        if(true) throw new RuntimeException("work3에서 예외 발생");

        postService.modify(post1, "제목 1 수정", "내용 1 수정");
    }
}