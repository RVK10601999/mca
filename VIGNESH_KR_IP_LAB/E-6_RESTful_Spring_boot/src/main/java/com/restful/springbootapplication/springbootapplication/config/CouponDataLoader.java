package com.restful.springbootapplication.springbootapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.restful.springbootapplication.springbootapplication.entity.Coupon;
import com.restful.springbootapplication.springbootapplication.repository.CouponRepository;

@Component
public class CouponDataLoader implements CommandLineRunner {

    private final CouponRepository couponRepository;

    @Autowired
    public CouponDataLoader(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public void run(String... args) {
        Coupon coupon1 = new Coupon();
        coupon1.setCode("ABC123");
        couponRepository.save(coupon1);

        Coupon coupon2 = new Coupon();
        coupon2.setCode("XYZ789");
        couponRepository.save(coupon2);
    }
}
