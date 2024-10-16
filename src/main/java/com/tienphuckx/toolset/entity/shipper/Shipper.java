package com.tienphuckx.toolset.entity.shipper;

import com.tienphuckx.toolset.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_shipper")
@DynamicInsert
@DynamicUpdate
@Data
public class Shipper extends BaseEntity {

    @Column(name = "shipper_name")
    private String shipperName;

    @OneToMany(mappedBy = "shipper")
    private List<Delivery> deliveries;
}
