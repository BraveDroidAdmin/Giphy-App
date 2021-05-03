package com.bravedroid.giphy.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bravedroid.giphy.R


class ManyGIFsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_many_gifs, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ManyGIFsFragment()
    }
}
