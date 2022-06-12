package com.mohammad.showcase.showcase

import android.graphics.RectF
import android.os.Parcelable
import androidx.annotation.ColorInt
import com.mohammad.showcase.callback.ShowCaseCallBack
import com.mohammad.showcase.ui.showcase.HighlightType
import com.mohammad.showcase.ui.tooltip.ArrowPosition
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowcaseModel(val rectF: RectF,
                         val radius: Float,
                         val titleText: String,
                         val descriptionText: String,
                         @ColorInt val titleTextColor: Int,
                         @ColorInt val descriptionTextColor: Int,
                         @ColorInt val popupBackgroundColor: Int,
                         @ColorInt val closeButtonColor: Int,
                         val showCloseButton: Boolean,
                         val arrowPosition: ArrowPosition,
                         val highlightType: HighlightType,
                         val arrowPercentage: Int?,
                         val windowBackgroundColor: Int,
                         val windowBackgroundAlpha: Int,
                         val titleTextSize: Float,
                         val descriptionTextSize: Float,
                         val highlightPadding: Float,
                         val cancellableFromOutsideTouch: Boolean
) : Parcelable {


    fun horizontalCenter() = rectF.left + ((rectF.right - rectF.left) / 2)
    fun verticalCenter() = rectF.top + ((rectF.bottom - rectF.top) / 2)

    fun bottomOfCircle() = verticalCenter() + radius
    fun topOfCircle() = verticalCenter() - radius

    companion object {

        internal lateinit var callBack: ShowCaseCallBack
        internal var isNextEnable= false
        internal var isPrevEnable= false

        fun setCallBack(callBack: ShowCaseCallBack) {
            this.callBack = callBack
        }
        fun isNextEnable(isEnable:Boolean){
            isNextEnable = isEnable
        }
        fun isPrevEnable(isEnable:Boolean){
            isPrevEnable = isEnable
        }

    }

}
