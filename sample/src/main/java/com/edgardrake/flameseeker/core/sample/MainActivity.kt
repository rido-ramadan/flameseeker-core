package com.edgardrake.flameseeker.core.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edgardrake.flameseeker.core.utils.replaceText
import com.edgardrake.flameseeker.core.utils.setTextListener
import com.edgardrake.flameseeker.core.utils.showDebug
import com.edgardrake.flameseeker.core.utils.toDP
import com.edgardrake.flameseeker.core.utils.toSP
import com.edgardrake.flameseeker.core.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Debug Dialog Playground"

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
            val title = titleText.text?.toString()
            debugClickCounter++

            showDebug(this,
                title = title,
                lhs = lhs,
                rhs = rhs,
                entries = listOf(
                    "100dp" to "${"100dp".toDP()}px",
                    "100sp" to "${"100sp".toSP()}px",
                    "10 dp" to "${"10 dp".toDP()}px",
                    "10 sp" to "${"10 sp".toSP()}px",
                )
            )
        }

        toastButton.setOnClickListener {
            val lhs = key.text.toString().toIntOrNull()
            val rhs = value.text.toString().toIntOrNull()
            val title = titleText.text?.toString()
            toastClickCounter++

            toast("key: $lhs, value: $rhs, title: $title\npressed: $toastClickCounter")
        }
    }

    private var debugClickCounter = 0
    private var toastClickCounter = 0
}
