package com.tienphuckx.toolset.entity.post;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.entity.tag.Tag;
import com.tienphuckx.toolset.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "tbl_post")
public class Post extends BaseEntity {

    @Column(name = "title", columnDefinition = "varchar(255)", nullable = false)
    private String title;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    // Define the Many-to-One relationship with User
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false) // Foreign key in tbl_post pointing to tbl_user
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_content_id")
    private PostContent postContent;

    @ManyToMany
    @JoinTable(
            name = "tbl_post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

}
