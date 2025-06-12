package com.back.domain.post.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity //아래 구조대로 DB 테이블을 만들어야 한다.
@Getter
@Setter
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id //Primary Key
    @GeneratedValue(strategy = IDENTITY) // Auto_increment
    private int id; //int
    @CreationTimestamp
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;
    private  String title; //varchar(255)
    @Column(columnDefinition = "TEXT")
    private  String content;

    public Post(String title, String content) {
        this.modifyDate = this.createDate;
        this.title = title;
        this.content = content;
    }
}
