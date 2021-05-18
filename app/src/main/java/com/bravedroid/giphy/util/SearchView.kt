package com.bravedroid.giphy.util

import android.animation.Animator
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import androidx.constraintlayout.widget.ConstraintLayout
import com.bravedroid.giphy.databinding.ViewSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchView constructor(context: Context, attrs: AttributeSet) :
    ConstraintLayout(context, attrs) {
    @Inject lateinit var logger: Logger

    var listener: Listener? = null

    private var viewSearchBinding: ViewSearchBinding =
        ViewSearchBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        viewSearchBinding.openSearchButton.setOnClickListener { openSearch() }
        viewSearchBinding.closeSearchButton.setOnClickListener { closeSearch() }
        watchSearchEditTextChanging()
    }

    private fun watchSearchEditTextChanging() {
        viewSearchBinding.searchInputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = Unit

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (count >= 1) {
                        logger.log("onTextChanged count >= 1","SEARCH_VIEW")
                        listener?.onStartTypingOnEditText()
                    } else {
                        logger.log("onTextChanged count == 0","SEARCH_VIEW")
                        listener?.onclearEditText()
                    }
                }
            }
        })
    }

    private fun openSearch() {
        viewSearchBinding.searchInputText.setText("")
        viewSearchBinding.searchOpenView.visibility = View.VISIBLE
        val circularReveal = ViewAnimationUtils.createCircularReveal(
            viewSearchBinding.searchOpenView,
            (viewSearchBinding.openSearchButton.right + viewSearchBinding.openSearchButton.left) / 2,
            (viewSearchBinding.openSearchButton.top + viewSearchBinding.openSearchButton.bottom) / 2,
            0f, width.toFloat()
        )
        circularReveal.duration = 300
        circularReveal.start()
    }

    private fun closeSearch() {
        val circularConceal = ViewAnimationUtils.createCircularReveal(
            viewSearchBinding.searchOpenView,
            (viewSearchBinding.openSearchButton.right + viewSearchBinding.openSearchButton.left) / 2,
            (viewSearchBinding.openSearchButton.top + viewSearchBinding.openSearchButton.bottom) / 2,
            width.toFloat(), 0f
        )

        circularConceal.duration = 300
        circularConceal.start()
        circularConceal.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) = Unit
            override fun onAnimationCancel(animation: Animator?) = Unit
            override fun onAnimationStart(animation: Animator?) = Unit
            override fun onAnimationEnd(animation: Animator?) {
                viewSearchBinding.searchOpenView.visibility = View.INVISIBLE
                viewSearchBinding.searchInputText.setText("")
                circularConceal.removeAllListeners()
            }
        })
    }

    interface Listener {
        fun onStartTypingOnEditText()
        fun onclearEditText()
    }
}
