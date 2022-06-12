package com.mohammad.showcase.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

@BindingMethods(value = [
    BindingMethod(
        type = ImageView::class,
        attribute = "app:tint",
        method = "setImageTintList")])
class BindingMethod
