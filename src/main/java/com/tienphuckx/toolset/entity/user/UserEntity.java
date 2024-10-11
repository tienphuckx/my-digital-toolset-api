package com.tienphuckx.toolset.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name = "tbl_user")
@DynamicInsert
@DynamicUpdate
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //not create a separate table for store id
    @Column(name = "id")
    private Long id;

    @Column(columnDefinition = "varchar(255) comment 'tbl_user.userName' ", nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(50) comment 'tbl_user.userPassword' ", nullable = false)
    private String userPassword;

    @Column(columnDefinition = "varchar(255) comment 'tbl_user.userEmail' ", nullable = false)
    private String userEmail;

    @Column(columnDefinition = "varchar(30) comment 'tbl_user.userPhone' ", nullable = false)
    private String userPhone;
}
