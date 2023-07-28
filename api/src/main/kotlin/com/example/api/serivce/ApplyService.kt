package com.example.api.serivce

import com.example.api.domain.Coupon
import com.example.api.repository.CouponRepository
import org.springframework.stereotype.Service

@Service
class ApplyService(
    protected val couponRepository: CouponRepository
) {
    fun apply(userId: Long) {
        val count = couponRepository.count()

        if (count > 100) {
            return
        }

        couponRepository.save(Coupon(userId))
    }
}
