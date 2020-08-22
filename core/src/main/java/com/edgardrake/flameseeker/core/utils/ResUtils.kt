package com.edgardrake.flameseeker.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 20-Aug-20
 */

inline val Int.dp: Int get() = (this * SystemMetrics.DP).toInt()

inline val Int.sp: Int get() = (this * SystemMetrics.SP).toInt()

// region Helper
/**
 * Wrapper singleton for [Resources] to enable 2 methods above to be mocked.
 * This object is not to be tested, as such the only purpose of this is to be a stub object.
 */
object SystemMetrics {
    internal val instance: DisplayMetrics = Resources.getSystem().displayMetrics

    val DP: Float = instance.density

    val SP: Float = instance.scaledDensity
}
// endregion