package com.restful.springbootapplication.springbootapplication.controller;

import com.restful.springbootapplication.springbootapplication.entity.Coupon;
import com.restful.springbootapplication.springbootapplication.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        Cache cache = cacheManager.getCache("coupons");
        System.out.println("Cache Content before clear: " + cache.getNativeCache());
        cache.clear();
        System.out.println("Cache Content after clear: " + cache.getNativeCache());
        List<Coupon> coupons = couponService.getAllCoupons();
        System.out.println("List of Coupon " + coupons);
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/admin/viewCoupon")
    public String adminView() {
        Cache cache = cacheManager.getCache("coupons");
        System.out.println("Cache Content: " + cache.getNativeCache());
        List<Coupon> coupons = couponService.getAllCoupons();
        System.out.println("List of Coupon " + coupons);
        return ("<h1>Welcome Admin Coupon View</h1>"+ cache.getNativeCache());
    }
}