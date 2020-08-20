package com.edgardrake.flameseeker.core.utils

import android.content.res.Resources

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 20-Aug-20
 */

inline val Int.dp : Int get() = this * Resources.getSystem().displayMetrics.density.toInt()

inline val Int.sp : Int get() = this * Resources.getSystem().displayMetrics.scaledDensity.toInt()
