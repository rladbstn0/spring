package com.back.domain.post.post.entity;


import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //아래 구조대로 DB 테이블을 만들어야 한다.
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post extends BaseEntity {
    private int authorId;
    private String title;
    private String content;
    private  String title; //varchar(255)
    @Column(columnDefinition = "TEXT")
    private  String content;

    public Post(int authorId, String title, String content) {
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }
}
