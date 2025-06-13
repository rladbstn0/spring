package com.back.global.jpa.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@MappedSuperclass // 엔티티의 부모 클래스는 이걸 달아야 한다
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id //Primary Ky
    @GeneratedValue(strategy = IDENTITY) // Auto_increment
    private int id;
    @CreationTimestamp
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;
}
