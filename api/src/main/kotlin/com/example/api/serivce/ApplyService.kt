package com.example.api.serivce

import com.example.api.producer.CouponCreateProducer
import com.example.api.repository.CouponCountRepository
import org.springframework.stereotype.Service

@Service
class ApplyService(
    private val couponCountRepository: CouponCountRepository,
    private val couponCreateProducer: CouponCreateProducer
) {
    fun apply(userId: Long) {
        val count = couponCountRepository.increment()

        if (count > 100) {
            return
        }

        couponCreateProducer.create(userId)
    }
}
