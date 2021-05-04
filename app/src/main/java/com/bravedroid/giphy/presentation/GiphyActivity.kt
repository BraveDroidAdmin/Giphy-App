package com.bravedroid.giphy.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import com.bravedroid.giphy.databinding.ActivityGiphyBinding
import com.bravedroid.giphy.util.ImageLoader
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GiphyActivity : AppCompatActivity() {

//    @Inject
//    lateinit var imageLoader: ImageLoader

    private lateinit var binding: ActivityGiphyBinding
    private lateinit var navController: NavController

    private val viewModel: RandomGifViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiphyBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel.loadContent()
//        viewModel.gifUrl.observe(this) {
//            imageLoader.setImageViewWithGlide(
//                binding.gifIV,
//                it
//            )
//        }
    }
}
