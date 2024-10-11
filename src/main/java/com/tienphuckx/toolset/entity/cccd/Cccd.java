package com.tienphuckx.toolset.entity.cccd;

import com.tienphuckx.toolset.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "tbl_cccd")
@DynamicInsert
@DynamicUpdate
@Data
public class Cccd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cccd_number", columnDefinition = "varchar(255) comment 'tbl_cccd.cccdNumber'", nullable = false, unique = true)
    private String cccdNumber;

    // One to One with User --> Only define in User is enough
}
