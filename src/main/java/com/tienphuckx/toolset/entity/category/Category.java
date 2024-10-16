package com.tienphuckx.toolset.entity.category;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.entity.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_category")
@Data
@DynamicUpdate
@DynamicInsert
@Entity
public class Category extends BaseEntity{
    @Column(name = "name", columnDefinition = "varchar(255) comment 'category name'", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "varchar(255) comment 'category description'")
    private String description;

    @ManyToMany
    @JoinTable(name = "tbl_category_product", //create this new table between
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
