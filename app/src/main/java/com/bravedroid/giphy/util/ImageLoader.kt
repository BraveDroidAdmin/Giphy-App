package com.bravedroid.giphy.util

import android.widget.ImageView
import com.bravedroid.giphy.R
import com.bravedroid.giphy.testing.OpenForTesting
import com.bumptech.glide.RequestManager

@OpenForTesting
interface ImageLoader {
    fun setImageViewWithNoTransform(
        imageView: ImageView,
        keyOfUrl: String,
    )
}

@OpenForTesting
class ImageLoaderImpl(
    private var glide: RequestManager
) : ImageLoader {
    override fun setImageViewWithNoTransform(
        imageView: ImageView,
        keyOfUrl: String,
    ) {
        with(keyOfUrl) {
            glide.load(this)
                .placeholder(R.drawable.placeholder)
                .dontTransform()
                .into(imageView)
        }
    }
}
