package com.edgardrake.flameseeker.core.views.recyclerview

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Rido Ramadan : rido-ramadan (email: rido.ramadan@gmail.com) on 21-Aug-20
 */
abstract class HomogenousLinearAdapter<T, VH : RecyclerView.ViewHolder>(
    val dataset: MutableList<T>,
    val onBindData: (VH.(position: Int, data: T?) -> Unit)? = null
) : RecyclerView.Adapter<VH>() {

    private var isStop: Boolean = false

    /**
     * Default: return dataset size
     */
    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindViewHolder(holder, position,
            if (position in 0 until dataset.size) dataset[position] else null
        )
    }

    open fun onBindViewHolder(holder: VH, position: Int, data: T?) {
        onBindData?.invoke(holder, position, data)
    }

    open fun attach(recyclerView: RecyclerView,
                    orientation: Int = RecyclerView.VERTICAL,
                    isReverse: Boolean = false,
                    isFromEnd: Boolean = false,
                    isRenderDivider: Boolean = true,
                    onScroll: (() -> Unit)? = null) {
        recyclerView.also {
            it.adapter = this
            if (it.layoutManager == null) {
                it.layoutManager = LinearLayoutManager(recyclerView.context, orientation, isReverse).apply {
                    stackFromEnd = isFromEnd
                }
            }
            if (isRenderDivider) {
                it.addItemDecoration(DividerItemDecoration(it.context, orientation))
            }
            it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    (recyclerView.layoutManager as? LinearLayoutManager)?.let { lm ->
                        if (lm.itemCount <= lm.findFirstVisibleItemPosition() + lm.childCount && !isStop) {
                            recyclerView.removeOnScrollListener(this)
                            onScroll?.invoke()
                        }
                    }
                }
            })
        }
    }

    fun stopLoading() {
        isStop = true
    }
}
