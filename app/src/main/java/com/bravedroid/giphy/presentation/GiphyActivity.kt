package com.bravedroid.giphy.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.bravedroid.giphy.R
import com.bravedroid.giphy.databinding.ActivityGiphyBinding
import dagger.hilt.android.AndroidEntryPoint

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

    override fun onStart() {
        super.onStart()
        navController = this.findNavController(R.id.fragmentContainerView)
        navController.navigate(R.id.gifFragment)
    }
}
