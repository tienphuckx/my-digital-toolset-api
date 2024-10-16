package com.tienphuckx.toolset.entity.user;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.entity.cccd.Cccd;
import com.tienphuckx.toolset.entity.post.Post;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "tbl_user")
@DynamicInsert
@DynamicUpdate
public class User extends BaseEntity {
    @Column(name = "user_email", columnDefinition = "varchar(255) comment 'tbl_user.userEmail'", nullable = false)
    private String userEmail;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Role {
        ADMIN, USER, CUSTOMER
    }

    // Define the One-to-Many relationship with Post
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @ToString.Exclude
    private List<Post> posts;

    // One User have one CCCD
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccd_id")
    private Cccd cccd;
}

