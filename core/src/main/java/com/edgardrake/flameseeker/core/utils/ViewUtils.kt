@file:JvmName("ViewUtils")
package com.edgardrake.flameseeker.core.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
            // Only invoke listener if input field has user focus
            // If listener attached not to input field, invoke listener
            if ((hasFocus() && this@setTextListener is EditText) || this@setTextListener !is EditText) {
                handler.postDelayed({ listener(text) }, delay)
            }
        }
    })
}

/**
 * Set the text inside [EditText] to the specified [text], while also ensuring that the cursor is at
 * the end of the text instead of start from the beginning again when [EditText.setText] is used.
 * If [text] is null, it will be replaced with empty string instead.
 */
fun EditText.replaceText(text: CharSequence?) {
    setText("")
    text?.let { append(it) }
}

/**
 * Simplify [View.getVisibility] and [View.setVisibility] from enum to Boolean
 */
var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if (value) View.VISIBLE else View.GONE }

/**
 * Simplify toast making, just pass [message], while [duration] become
 * optional with default value of [Toast.LENGTH_SHORT]
 */
fun Context.toast(message: String?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}