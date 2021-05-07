package com.bravedroid.giphy.util

import android.widget.ImageView
import com.bravedroid.giphy.R
import com.bravedroid.giphy.testing.OpenForTesting
import com.bumptech.glide.RequestManager

@OpenForTesting
interface ImageLoader {
    fun setImageViewWithGlide(
        imageView: ImageView,
        keyOfUrl: String,
    )

    fun setImageViewWithGlide2(
        imageView: ImageView,
        keyOfUrl: String,
    )

}

@OpenForTesting
class ImageLoaderImpl(
    private var glide: RequestManager
) : ImageLoader {
    override fun setImageViewWithGlide(
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

    override fun setImageViewWithGlide2(
        imageView: ImageView,
        keyOfUrl: String,
    ) {
        with(keyOfUrl) {
            glide.load(this)
                .placeholder(R.drawable.placeholder)
                .fitCenter()
                .into(imageView)
        }
    }
}
