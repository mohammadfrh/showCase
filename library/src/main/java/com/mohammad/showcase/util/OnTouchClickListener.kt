package com.mohammad.showcase.util

import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

/**
 *
 * source = https://github.com/hoffergg/BaseLibrary/blob/master/src/main/java/com/dailycation/base/view/listener/OnTouchClickListener.java
 */
class OnTouchClickListener(private val minMove: Int = 10) : View.OnTouchListener {

    private var startX: Float = 0.toFloat()
    private var startY: Float = 0.toFloat()
    var clickListener: ((v: View, x: Float, y: Float) -> Unit)? = null

    private fun isAClick(startX: Float, endX: Float, startY: Float, endY: Float): Boolean {
        val differenceX = abs(startX - endX)
        val differenceY = abs(startY - endY)
        return !(differenceX > minMove || differenceY > minMove)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
                return true
            }
            MotionEvent.ACTION_UP -> {
                val endX = event.x
                val endY = event.y
                if (isAClick(startX, endX, startY, endY)) {
                    clickListener?.invoke(v, event.x, event.y)
                    return true
                }
            }
        }
        return false
    }
}
