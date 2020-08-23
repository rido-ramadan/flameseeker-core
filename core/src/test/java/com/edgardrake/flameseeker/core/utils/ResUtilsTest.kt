package com.edgardrake.flameseeker.core.utils

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 22-Aug-20
 */
class ResUtilsTest {

    companion object {
        @JvmStatic @BeforeClass
        fun setUpClass() {
            mockkObject(SystemMetrics)
            every { SystemMetrics.DP } returns 2.75f
            every { SystemMetrics.SP } returns 3.0f
        }

        @JvmStatic @AfterClass
        fun tearDownClass() {
            unmockkAll()
        }
    }

    @Test
    fun `10dp is 28px`() {
        assertEquals(10.dp, 28)
    }

    @Test
    fun `10sp is 30px`() {
        assertEquals(10.sp, 30)
    }
}