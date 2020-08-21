package com.edgardrake.flameseeker.core.utils

import android.content.Context
import com.edgardrake.flameseeker.core.views.dialogs.DebugDialog

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 21-Aug-20
 */

fun showDebug(
    context: Context,
    title: String? = null,
    lhs: Int? = null,
    rhs: Int? = null,
    entries: List<Pair<String?, String?>>
) {
   DebugDialog(context, entries, title, lhs, rhs)
}

fun showDebug(context: Context, entries: List<Pair<String?, String?>>) =
    showDebug(context, null, null, null, entries)