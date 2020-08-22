package com.edgardrake.flameseeker.core.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 22-Aug-20
 */
class DateUtilsTest {
    @Test
    fun `Month 1 == January`() {
        val januaryAccordingHuman = 1
        assertEquals(D2_JAN_2020.month(), januaryAccordingHuman)
    }

    @Test
    fun `Year 2020 in Date == 2020`() {
        assertEquals(D2_JAN_2020.year(), 2020)
    }

    companion object {
        private const val YEAR_2020 = 2020
        private const val JANUARY_IN_JVM = 0
        private const val DATE_2 = 2

        private val D2_JAN_2020 = Calendar.getInstance().apply {
            set(YEAR_2020, JANUARY_IN_JVM, DATE_2)
        }.time
    }
}
