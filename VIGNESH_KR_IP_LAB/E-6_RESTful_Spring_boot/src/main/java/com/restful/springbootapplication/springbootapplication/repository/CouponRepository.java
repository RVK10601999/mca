package com.restful.springbootapplication.springbootapplication.repository;

import com.restful.springbootapplication.springbootapplication.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findAll();
}
