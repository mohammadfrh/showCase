package com.mohammad.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mohammad.sample.databinding.ActivityMainBinding
import com.mohammad.showcase.callback.ShowCaseCallBack
import com.mohammad.showcase.showcase.ShowcaseManager
import com.mohammad.showcase.ui.showcase.HighlightType
import com.mohammad.showcase.ui.tooltip.ArrowPosition
import java.util.*

class MainActivity : AppCompatActivity(), ShowCaseCallBack {

    private lateinit var binding: ActivityMainBinding

    val modelShowCases = ArrayList<ModelTest>()
    val modelShowCase1 = ModelTest()
    val modelShowCase2 = ModelTest()
    val modelShowCase3 = ModelTest()

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        modelShowCase1.title =
            "غالب خدمات این سامانه با احراز هویت همین سطح قابل انجام است که در آن اقلام اطلاعاتی شما از طریق سازمان\u200Cهای متولی بررسی می\u200Cشود."
        modelShowCase1.viewId = binding.buttonTop
        modelShowCases.add(modelShowCase1)

        modelShowCase2.title =
            "غالب خدمات این سامانه با احراز هویت همین سطح قابل انجام است که در آن اقلام اطلاعاتی شما از طریق سازمان\u200Cهای متولی بررسی می\u200Cشود."
        modelShowCase2.viewId = binding.buttonCenter
        modelShowCases.add(modelShowCase2)

        modelShowCase3.title =
            "غالب خدمات این سامانه با احراز هویت همین سطح قابل انجام است که در آن اقلام اطلاعاتی شما از طریق سازمان\u200Cهای متولی بررسی می\u200Cشود."
        modelShowCase3.viewId = binding.buttonBottom
        modelShowCases.add(modelShowCase3)

        initClick()
    }

    private fun initClick() {
        binding.buttonShowCaseView.setOnClickListener {
            showCaseItems(position)
        }
        ShowcaseManager.setCallBack(this)
    }

    private fun showCaseItems(position: Int) {
        if (position == -1 || position >= modelShowCases.size)
            return
        if(position == 0)
            ShowcaseManager.isPrevEnable(false)
        else
            ShowcaseManager.isPrevEnable(true)

        if(position == modelShowCases.size-1)
            ShowcaseManager.isNextEnable(false)
        else
            ShowcaseManager.isNextEnable(true)


        ShowcaseManager.Builder()
            .view(modelShowCases[position].viewId)
            .titleText(modelShowCases[position].title)
            .titleTextColor(ContextCompat.getColor(baseContext, R.color.white))
            .descriptionTextColor(ContextCompat.getColor(baseContext, R.color.white))
            .backgroundColor(ContextCompat.getColor(baseContext, R.color.colorPrimaryDark))
            .closeButtonColor(ContextCompat.getColor(baseContext, R.color.white))
            .showCloseButton(true)
            .arrowPosition(ArrowPosition.AUTO)
            .highlightType(HighlightType.CIRCLE)
            .windowBackgroundAlpha(200)
            .titleTextSize(15f)
            .build()
            .show(this@MainActivity, 0)
    }

    override fun onNextItemClick() {
        position += 1
        showCaseItems(position);
    }

    override fun onLastItemClick() {
        position -= 1
        showCaseItems(position);
    }
}
