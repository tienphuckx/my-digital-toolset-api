package com.tienphuckx.toolset.entity.customer;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.entity.shipper.Delivery;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_customer")
@Data
@DynamicUpdate
@DynamicInsert
public class Customer extends BaseEntity {

    @OneToMany(mappedBy = "customer")
    private List<Delivery> deliveries;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_username", columnDefinition = "varchar(255)", nullable = false)
    private String customerUserName;

    @Column(name = "customer_password", columnDefinition = "varchar(50)", nullable = false)
    private String userPassword;

    @Column(name = "customer_email", columnDefinition = "varchar(255)", nullable = false)
    private String userEmail;

    @Column(name = "customer_level")
    private String customerLevel;
}
