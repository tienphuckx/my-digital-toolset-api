package com.tienphuckx.toolset.entity.product;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.entity.category.Category;
import com.tienphuckx.toolset.entity.cccd.Cccd;
import com.tienphuckx.toolset.entity.order.Order;
import com.tienphuckx.toolset.entity.order.OrderItem;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_product")
@DynamicUpdate
@DynamicInsert
@Data
public class Product extends BaseEntity {

    @Column(name = "product_name", columnDefinition = "varchar(255)", nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private BigDecimal productPrice;

    /*
        One Product have one ProductDetail
        --> Only define in Product is enough
    */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

    //onr product will be present in many Order Item
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

}
