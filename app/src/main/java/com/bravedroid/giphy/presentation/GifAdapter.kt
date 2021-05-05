package com.bravedroid.giphy.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bravedroid.giphy.databinding.GifBinding

class GifAdapter(
    private val callback: (gifUiModel: GifUiModel, imageView: ImageView) -> Unit
) : ListAdapter<GifUiModel, GifAdapter.GifViewHolder>(DiffUtilCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, holder, callback)
    }

    class GifViewHolder(private val binding: GifBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup) = GifViewHolder(
                GifBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

        fun bind(
            gifUiModel: GifUiModel,
            holder: GifViewHolder,
            callback: (gifUiModel: GifUiModel, imageView: ImageView) -> Unit,
        ) {
            holder.itemView.setOnClickListener {
                callback.invoke(gifUiModel, binding.gifIV)
            }
        }
    }

    private object DiffUtilCallBack : DiffUtil.ItemCallback<GifUiModel>() {
        override fun areItemsTheSame(oldItem: GifUiModel, newItem: GifUiModel): Boolean =
            oldItem.url == newItem.url

        override fun areContentsTheSame(oldItem: GifUiModel, newItem: GifUiModel): Boolean =
            oldItem.url == newItem.url
    }
}
