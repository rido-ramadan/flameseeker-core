package com.edgardrake.flameseeker.core.views.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.edgardrake.flameseeker.core.R
import com.edgardrake.flameseeker.core.views.recyclerview.HomogenousLinearAdapter
import kotlinx.android.synthetic.main.dialog_debug.view.*
import kotlinx.android.synthetic.main.vh_key_value.view.*

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 21-Aug-20
 */
class DebugDialog @JvmOverloads constructor(
    context: Context,
    entries: List<Pair<String?, Any?>>,
    title: String? = null,
    lhs: Int? = null,
    rhs: Int? = null
) {
    init {
        val layout = LayoutInflater.from(context)
            .inflate(R.layout.dialog_debug, null, false).apply {
                Adapter(entries, lhs, rhs).attach(recyclerView, isRenderDivider = false)
            }

        AlertDialog.Builder(context)
            .setView(layout)
            .setTitle(title)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }


    private class Adapter @JvmOverloads constructor(
        dataset: List<Pair<String?, Any?>>,
        private val lhs: Int? = null,
        private val rhs: Int? = null
    ) : HomogenousLinearAdapter<Pair<String?, Any?>, EntryHolder>(dataset.toMutableList()) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            EntryHolder(parent, lhs, rhs)

        override fun onBindViewHolder(
            holder: EntryHolder,
            position: Int,
            data: Pair<String?, Any?>?
        ) {
            holder.apply {
                key = data?.first
                value = data?.second.toString()
            }
        }
    }

    private class EntryHolder @JvmOverloads constructor(
        view: View,
        lhs: Int? = null,
        rhs: Int? = null
    ) : RecyclerView.ViewHolder(view) {

        @JvmOverloads
        constructor(parent: ViewGroup, lhs: Int? = null, rhs: Int? = null) : this(
            LayoutInflater.from(parent.context).inflate(R.layout.vh_key_value, parent, false),
            lhs, rhs
        )

        init {
            lhs?.let { weight ->
                (itemView.key.layoutParams as LinearLayout.LayoutParams).weight = weight.toFloat()
            }

            rhs?.let { weight ->
                (itemView.value.layoutParams as LinearLayout.LayoutParams).weight = weight.toFloat()
            }
        }

        var key : String?
            get() = itemView.key.text.toString()
            set(value) { itemView.key.text = value ?: "" }

        var value : String?
            get() = itemView.value.text.toString()
            set(value) { itemView.value.text = value ?: ""}
    }
}

