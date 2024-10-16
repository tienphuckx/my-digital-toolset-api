package com.tienphuckx.toolset.entity.shipper;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import com.tienphuckx.toolset.entity.customer.Customer;
import com.tienphuckx.toolset.entity.order.Order;
import com.tienphuckx.toolset.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_delivery")
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Delivery extends BaseEntity {

    @Column(name = "delivery_status")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column(name = "delivery_time_start")
    private LocalDateTime deliveryTimeStart;

    @Column(name = "estimated_completion_time")
    private LocalDateTime estimatedCompletionTime;

    @Column(name = "actual_completion_time")
    private LocalDateTime actualCompletionTime;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
