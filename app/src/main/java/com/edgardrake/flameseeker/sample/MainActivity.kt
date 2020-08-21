package com.edgardrake.flameseeker.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edgardrake.flameseeker.core.utils.replaceText
import com.edgardrake.flameseeker.core.utils.setTextListener
import com.edgardrake.flameseeker.core.utils.showDebug
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        key.setTextListener { text ->
            text.toString().toIntOrNull()?.let {
                when {
                    it in 0 .. 100 -> value.replaceText("${100 - it}")
                    it < 0 -> {
                        value.replaceText("100")
                        key.replaceText("0")
                    }
                    it > 100 -> {
                        value.replaceText("0")
                        key.replaceText("100")
                    }
                }
            } ?: value.replaceText(null)
        }

        value.setTextListener { text ->
            text.toString().toIntOrNull()?.let {
                when {
                    it in 0 .. 100 -> key.setText("${100 - it}")
                    it < 0 -> {
                        key.replaceText("100")
                        value.replaceText("0")
                    }
                    it > 100 -> {
                        key.replaceText("0")
                        value.replaceText("100")
                    }
                }
            } ?: key.replaceText(null)
        }

        button.setOnClickListener {
            val lhs = key.text.toString().toIntOrNull()
            val rhs = value.text.toString().toIntOrNull()

            showDebug(this,
                title = titleText.text?.toString(),
                lhs = lhs,
                rhs = rhs,
                entries = (1 .. 10).toList().map {
                    "key-$it" to "value-$it"
                }
            )
        }
    }
}