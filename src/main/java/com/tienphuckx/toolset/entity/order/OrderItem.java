package com.tienphuckx.toolset.entity.order;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.entity.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "tbl_order_item")
public class OrderItem extends BaseEntity {

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_price")
    private Double totalPrice;

    //one product item is stored only ONE product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //and on order will stored many Order Item
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
