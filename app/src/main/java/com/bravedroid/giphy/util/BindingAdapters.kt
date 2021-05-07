package com.bravedroid.giphy.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


@BindingAdapter("app:verticalStaggeredGridLayoutSpanCount")
fun setVerticalStaggeredGridLayout(recyclerView: RecyclerView, spanCount: Int) {
    recyclerView.layoutManager =
        StaggeredGridLayoutManager(spanCount, RecyclerView.VERTICAL).apply {
            gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        }
}
