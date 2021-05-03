package com.bravedroid.giphy.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bravedroid.giphy.R
import com.bravedroid.giphy.databinding.FragmentGifBinding
import com.bravedroid.giphy.presentation.random.RandomGifViewModel
import com.bravedroid.giphy.util.ImageLoader
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

        viewModel.loadContent()
        viewModel.gifUrl.observe(viewLifecycleOwner) {
            imageLoader.setImageViewWithGlide(
                binding.gifIV,
                it
            )
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
