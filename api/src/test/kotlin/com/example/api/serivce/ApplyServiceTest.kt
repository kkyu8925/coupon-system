package com.example.api.serivce

import com.example.api.repository.CouponRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApplyServiceTes @Autowired constructor(
    private val applyService: ApplyService,
    private val couponRepository: CouponRepository
) {

    @Test
    fun 한번만응모() {
        applyService.apply(1L)

        val count = couponRepository.count()

        assertThat(count).isEqualTo(1)
    }
}
