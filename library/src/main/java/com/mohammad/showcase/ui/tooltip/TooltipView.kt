package com.mohammad.showcase.ui.tooltip

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.mohammad.showcase.R
import com.mohammad.showcase.callback.ShowCaseCallBack
import com.mohammad.showcase.databinding.LayoutTooltipBinding
import com.mohammad.showcase.util.getShowcaseActivity

class TooltipView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: LayoutTooltipBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
        R.layout.layout_tooltip, rootView as ViewGroup, true)

    private lateinit var callBack:ShowCaseCallBack

    fun bind(tooltipViewState: TooltipViewState) {
        binding.imageViewTooltipClose.setOnClickListener {
            getShowcaseActivity()?.onBackPress()
        }
        binding.tooltipViewState = tooltipViewState
        binding.executePendingBindings()
    }

}
