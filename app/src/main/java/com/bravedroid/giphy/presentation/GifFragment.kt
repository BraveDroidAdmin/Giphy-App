package com.bravedroid.giphy.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
import androidx.recyclerview.widget.StaggeredGridLayoutManager.GAP_HANDLING_NONE
import com.bravedroid.giphy.R
import com.bravedroid.giphy.databinding.FragmentGifBinding
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

//        viewModel.loadContent()
        viewModel.gifUrl.observe(viewLifecycleOwner) {
//            imageLoader.setImageViewWithGlide(
//                binding.gifIV,
//                it
//            )
        }
//        setupSingleLayout()
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadContent()
        setupSingleLayout()

    }

    private fun setupSingleLayout() {
        val gifAdapter = GifAdapter(imageLoader,::setSingleMasterContent)
        binding.gifsRecyclerView.adapter = gifAdapter
        viewModel.gifsUrl.observe(viewLifecycleOwner) {
            gifAdapter.submitList(it)
        }
    }

    private fun setSingleMasterContent(gifUiModel: GifUiModel, imageView: ImageView){
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
