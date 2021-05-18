package com.bravedroid.giphy.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.bravedroid.giphy.R
import com.bravedroid.giphy.databinding.FragmentGifBinding
import com.bravedroid.giphy.util.ImageLoader
import com.bravedroid.giphy.util.SearchView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GifFragment : Fragment(R.layout.fragment_gif) {

    @Inject
    lateinit var imageLoader: ImageLoader

    private var _binding: FragmentGifBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RandomGifViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGifBinding.bind(view)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadContent()
        viewModel.randomGifUrl.observe(viewLifecycleOwner) {
            imageLoader.setImageViewWithGlide(
                binding.gifIV,
                it
            )
            binding.gifsRecyclerView.isVisible = false
        }
        binding.gifSearch.listener = object : SearchView.Listener {
            override fun onStartTypingOnEditText() {
                binding.gifIV.isVisible = false
                binding.gifsRecyclerView.isVisible = true
                setUpGifsRecyclerView()
            }

            override fun onclearEditText() {
                    binding.gifIV.isVisible = true
                    binding.gifsRecyclerView.isVisible = false
            }
        }
    }

    private fun setUpGifsRecyclerView() {
        val gifAdapter = GifAdapter(imageLoader, ::setUpRandomGifView)
        binding.gifsRecyclerView.adapter = gifAdapter
        viewModel.allGifsUrl.observe(viewLifecycleOwner) {
            gifAdapter.submitList(it)
        }
    }

    private fun setUpRandomGifView(gifUiModel: GifUiModel, imageView: ImageView) {
        imageLoader.setImageViewWithGlide(
            imageView,
            gifUiModel.url
        )
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = GifFragment()
    }
}
