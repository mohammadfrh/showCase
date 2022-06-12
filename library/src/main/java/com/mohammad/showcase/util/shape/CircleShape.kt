package com.mohammad.showcase.util.shape

import android.graphics.Canvas

class CircleShape(private val statusBarDiff: Int,
                  screenWidth: Int,
                  screenHeight: Int,
                  private val x: Float,
                  private val y: Float,
                  private val radius: Float) : Shape(screenWidth, screenHeight) {

    override fun draw(windowBackgroundColor: Int, windowBackgroundAlpha: Int, canvas: Canvas) {
        super.draw(windowBackgroundColor, windowBackgroundAlpha, canvas)
        canvas.drawCircle(x, y + statusBarDiff, radius, paint)
    }
}
