package com.tienphuckx.toolset.entity.email;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.enums.EmailType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_email")
@Data
@DynamicUpdate
@DynamicInsert
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email extends BaseEntity {

    @Column( name = "mail_from", nullable = false)
    private String from;

    @Column( name = "mail_to", nullable = false)
    private String to;

    @Column( name = "subject", nullable = false)
    private String subject;

    @Lob
    @Column( name = "body", nullable = false)
    private String body;

    @Column(name = "attachment")
    private String attachment;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EmailType emailType;
}
