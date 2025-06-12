package com.back.domain.post.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity //아래 구조대로 DB 테이블을 만들어야 한다.
@Getter
@Setter
public class Post {
    @Id //Primary Key
    @GeneratedValue(strategy = IDENTITY) // Auto_increment
    private int id; //int
    private String title; //varchar(255)
}
