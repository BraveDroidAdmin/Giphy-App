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

    private var myQuery: String = "dogs"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGifBinding.bind(view)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadRandomGifContent()
        viewModel.randomGifUrl.observe(viewLifecycleOwner) {
            setUpRandomGifView(it, binding.gifIV)
        }

        binding.gifsRecyclerView.isVisible = false
        setUpGifsRecyclerView()

        binding.gifSearch.listener = object : SearchView.Listener {

            override fun onStartTypingOnEditText(query: String) {
                viewModel.loadSearchGifsContent(query)
                binding.gifsRecyclerView.isVisible = true
                binding.gifIV.isVisible = false
            }

            override fun onClearEditText() {
                binding.gifIV.isVisible = true
                binding.gifsRecyclerView.isVisible = false
            }
        }
    }

    private fun setUpRandomGifView(gifUiModel: GifUiModel, imageView: ImageView) {
        imageLoader.setImageViewWithGlide(
            imageView,
            gifUiModel.url
        )
    }

    private fun setUpGifsRecyclerView() {
        val gifAdapter = GifAdapter(imageLoader)
        binding.gifsRecyclerView.adapter = gifAdapter
        viewModel.allGifsUrl.observe(viewLifecycleOwner) {
            gifAdapter.submitList(it)
        }
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
