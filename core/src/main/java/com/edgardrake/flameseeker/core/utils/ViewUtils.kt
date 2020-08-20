package com.edgardrake.flameseeker.core.utils

import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import com.edgardrake.flameseeker.core.R

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 20-Aug-20
 */

/**
 * Set single exclusive text watcher. It means that [TextView] using this method can only support
 * one [TextWatcher] only.
 */
fun TextView.setTextListener(delay: Long = 0, listener: (text: CharSequence?) -> Unit) {
    // Remove existing text watcher
    (getTag(R.id.textWatcher) as? TextWatcher)?.let { removeTextChangedListener(it) }

    val handler: Handler = (getTag(R.id.textHandler) as? Handler) ?: run {
        val newHandler = Handler(Looper.getMainLooper())
        setTag(R.id.textHandler, newHandler)
        newHandler
    }.apply { removeCallbacksAndMessages(null) }

    // Replace with new text watcher
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(text: Editable?) {
            handler.removeCallbacksAndMessages(null)
            if (hasFocus()) {
                handler.postDelayed({ listener(text) }, delay)
            }
        }
    })
}

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if (value) View.VISIBLE else View.GONE }