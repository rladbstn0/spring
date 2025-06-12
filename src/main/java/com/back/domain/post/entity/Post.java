package com.back.domain.post.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity //아래 구조대로 DB 테이블을 만들어야 한다.
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Post {
    @Id //Primary Key
    @GeneratedValue(strategy = IDENTITY) // Auto_increment
    private int id; //int
    private final String title; //varchar(255)
    @Column(columnDefinition = "TEXT")
    private final String content;

    public Post(){
        this.title = "";
        this.content = "";
    }
}
