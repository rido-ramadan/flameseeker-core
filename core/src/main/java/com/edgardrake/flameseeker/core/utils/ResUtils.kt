@file:JvmName("ResUtils")
package com.edgardrake.flameseeker.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.roundToInt

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 20-Aug-20
 */

/**
 * Convert given int from DP to PX. This method return value has been thoroughly
 * compared against real pixel value extracted from inflating view XML.
 *
 * To mock unit test using mockk: code below or see
 * [Github](https://github.com/rido-ramadan/flameseeker-core/blob/master/core/src/test/java/com/edgardrake/flameseeker/core/utils/ResUtilsTest.kt)
 * ```
 * mockkStatic("com.edgardrake.flameseeker.core.utils.ResUtils")
 * every { 10.dp } returns 28
 * ```
 */
val Int.dp: Int get() = (this * SystemMetrics.DP).roundToInt()

/**
 * Convert given int from SP to PX. This method return value has been thoroughly
 * compared against real pixel value extracted from inflating view XML.
 *
 * To mock unit test using mockk: code below or see
 * [Github](https://github.com/rido-ramadan/flameseeker-core/blob/master/core/src/test/java/com/edgardrake/flameseeker/core/utils/ResUtilsTest.kt)
 * ```
 * mockkStatic("com.edgardrake.flameseeker.core.utils.ResUtils")
 * every { 10.sp } returns 28
 * ```
 */
val Int.sp: Int get() = (this * SystemMetrics.SP).roundToInt()

// region Helper
/**
 * Wrapper singleton for [Resources.getDisplayMetrics] to enable 2 methods above to be mocked.
 * This object is not to be tested, as such the only purpose of this is to be a stub object.
 */
object SystemMetrics {
    internal val instance: DisplayMetrics by lazy { Resources.getSystem().displayMetrics }

    val DP: Float get() = instance.density

    val SP: Float get() = instance.scaledDensity
}
// endregion