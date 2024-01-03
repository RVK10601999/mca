package com.restful.springbootapplication.springbootapplication.service;

import com.restful.springbootapplication.springbootapplication.entity.Coupon;
import com.restful.springbootapplication.springbootapplication.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CacheManager cacheManager;

    @Cacheable(cacheNames = "coupons")
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}