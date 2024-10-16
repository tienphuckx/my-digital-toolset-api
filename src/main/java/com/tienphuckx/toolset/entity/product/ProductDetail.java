package com.tienphuckx.toolset.entity.product;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "tbl_product_des")
public class ProductDetail extends BaseEntity {
    @Column(name = "product_description", columnDefinition = "varchar(255) comment 'short description' ", nullable = false)
    private String productDescription;
}
