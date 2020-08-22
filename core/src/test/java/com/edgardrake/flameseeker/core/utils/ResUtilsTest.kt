package com.edgardrake.flameseeker.core.utils

import android.content.res.Resources
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.mockkStatic
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
            // Resource must be mocked first in order to properly mock SystemMetrics constructor
            mockkStatic(Resources::class)
            every { Resources.getSystem() } returns mockk(relaxed = true)

            mockkObject(SystemMetrics)
            every { SystemMetrics.DP } returns 2
            every { SystemMetrics.SP } returns 3
        }

        @JvmStatic @AfterClass
        fun tearDownClass() {
            unmockkAll()
        }
    }

    @Test
    fun `10dp is 20px`() {
        assertEquals(10.dp, 20)
    }

    @Test
    fun `14sp is 42px`() {
        assertEquals(14.sp, 42)
    }
}
