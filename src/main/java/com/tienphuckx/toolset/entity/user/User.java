package com.tienphuckx.toolset.entity.user;

import com.tienphuckx.toolset.entity.cccd.Cccd;
import com.tienphuckx.toolset.entity.post.Post;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Data
@Table(name = "tbl_user")
@DynamicInsert
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", columnDefinition = "varchar(255) comment 'tbl_user.userName'", nullable = false)
    private String userName;

    @Column(name = "user_password", columnDefinition = "varchar(50) comment 'tbl_user.userPassword'", nullable = false)
    private String userPassword;

    @Column(name = "user_email", columnDefinition = "varchar(255) comment 'tbl_user.userEmail'", nullable = false)
    private String userEmail;

    @Column(name = "user_phone", columnDefinition = "varchar(30) comment 'tbl_user.userPhone'", nullable = false)
    private String userPhone;

    // Define the One-to-Many relationship with Post
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @ToString.Exclude
    private List<Post> posts;

    // One User have one CCCD
    // One to One with Cccd --> Only define in User is enough
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccd_id")
    private Cccd cccd;

}
