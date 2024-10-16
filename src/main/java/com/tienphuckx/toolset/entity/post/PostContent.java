package com.tienphuckx.toolset.entity.post;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_post_content")
@DynamicUpdate
@DynamicInsert
@Data
public class PostContent extends BaseEntity {
    @Lob
    @Column(name = "post_content", columnDefinition = "TEXT")
    private String content;

}
