package com.tienphuckx.toolset.entity.tag;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.entity.post.Post;
import com.tienphuckx.toolset.entity.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Data
@Table(name = "tbl_tag")
public class Tag extends BaseEntity {

    @Column(name = "name", columnDefinition = "varchar(255) comment 'category name'", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "varchar(255) comment 'category description'")
    private String description;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
}
