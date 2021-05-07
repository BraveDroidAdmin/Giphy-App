package com.bravedroid.giphy.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bravedroid.giphy.R
import com.bravedroid.giphy.databinding.GifBinding
import com.bravedroid.giphy.util.ImageLoader
import javax.inject.Inject

class GifAdapter @Inject constructor(
    private val imageLoader: ImageLoader,
    private val callback: (gifUiModel: GifUiModel, imageView: ImageView) -> Unit
) : ListAdapter<GifUiModel, GifAdapter.GifViewHolder>(DiffUtilCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, callback, imageLoader)
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
            callback: (gifUiModel: GifUiModel, imageView: ImageView) -> Unit,
            imageLoader: ImageLoader,
        ) {
            imageLoader.setImageViewWithGlide2(binding.gifIV,gifUiModel.url)
//            holder.itemView.setOnClickListener {
//                callback.invoke(gifUiModel, binding.gifIV)
//            }
        }
    }

    private object DiffUtilCallBack : DiffUtil.ItemCallback<GifUiModel>() {
        override fun areItemsTheSame(oldItem: GifUiModel, newItem: GifUiModel): Boolean =
            oldItem.url == newItem.url

        override fun areContentsTheSame(oldItem: GifUiModel, newItem: GifUiModel): Boolean =
            oldItem.url == newItem.url
    }
}
