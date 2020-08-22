package com.edgardrake.flameseeker.core.utils

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 22-Aug-20
 */
class PrimitiveUtilsTest {

    @Test
    fun `"1000" isNumber, not isDecimal`() {
        val num: CharSequence = "1000"
        assertEquals(num.isNumber(), true)
        assertEquals(num.isDecimal(), false)
    }

    @Test
    fun `"1000_0" isNumber`() {
        val num: CharSequence = "1000.0"
        assertEquals(num.isDecimal(), true)
        assertEquals(num.isNumber(), true)
    }

    @Test
    fun `null is neither number nor decimal`() {
        val num: CharSequence? = null
        assertEquals(num.isNumber(), false)
        assertEquals(num.isDecimal(), false)
    }

    @Test
    fun `"Test" is neither number nor decimal`() {
        val num: CharSequence? = "Test"
        assertEquals(num.isNumber(), false)
        assertEquals(num.isDecimal(), false)
    }
}
