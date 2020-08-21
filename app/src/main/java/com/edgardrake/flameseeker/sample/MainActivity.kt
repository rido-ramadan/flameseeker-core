package com.edgardrake.flameseeker.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.edgardrake.flameseeker.core.views.dialogs.DebugDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val keyWidthPercentage = key.text.toString().let { if (isNumber(it)) it.toInt() else -1 }
            val valueWidthPercentage = value.text.toString().let { if (isNumber(it)) it.toInt() else -1 }

            Log.d("wh", "$keyWidthPercentage : $valueWidthPercentage")

            DebugDialog(this,
                title = "Title",
                entries = (1 .. 10).toList().map {
                    "key-$it" to "value-$it"
                }
            )
        }
    }

    private fun isNumber(text: String) = text.matches(Regex("\\d+"))
}