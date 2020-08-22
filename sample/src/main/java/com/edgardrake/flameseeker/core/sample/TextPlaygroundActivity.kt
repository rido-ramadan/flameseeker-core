package com.edgardrake.flameseeker.core.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edgardrake.flameseeker.core.utils.setTextListener
import com.edgardrake.flameseeker.core.utils.toast
import kotlinx.android.synthetic.main.activity_text_playground.*

class TextPlaygroundActivity : AppCompatActivity() {

    private var listenerInvokeCounter: Int = 0
    private var delay: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_playground)
        supportActionBar?.title = "Text Listener Playground"

        counter = 0

        immediateText.setTextListener(delay, ::onTextChanged)
        enableDelay500.setOnCheckedChangeListener { _, enabled ->
            delay = if (enabled) 500 else 0
            // Change the text watcher system with/without delay
            immediateText.setTextListener(delay, ::onTextChanged)
        }

        message.setTextListener { toast(it.toString()) }

        resetButton.setOnClickListener {
            counter = 0
        }
    }

    private fun onTextChanged(text: CharSequence?) {
        listenerInvokeCounter++
        message.text = "Your message is:\n\n$text"
        counter = listenerInvokeCounter
    }

    private var counter: Int
        get() = listenerInvokeCounter
        set(value) {
            listenerInvokeCounter = value
            invokeCounter.text = "Invoked: ${value}x"
        }
}