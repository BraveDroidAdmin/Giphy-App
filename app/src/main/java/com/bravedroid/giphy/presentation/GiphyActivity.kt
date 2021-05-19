package com.bravedroid.giphy.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.bravedroid.giphy.R
import com.bravedroid.giphy.databinding.ActivityGiphyBinding
import com.bravedroid.giphy.util.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GiphyActivity : AppCompatActivity() {

    @Inject
    lateinit var logger: Logger
    private lateinit var binding: ActivityGiphyBinding
    private lateinit var navController: NavController

    private val viewModel: RandomGifViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.log("onCreated", "@@@@@@@@@@@@@@@@GiphyActivity")
        binding = ActivityGiphyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        navController = this.findNavController(R.id.fragmentContainerView)
    }
}
