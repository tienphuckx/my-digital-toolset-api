package com.tienphuckx.toolset.repository;

import com.tienphuckx.toolset.entity.cccd.Cccd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Cccd, Long> {
}
