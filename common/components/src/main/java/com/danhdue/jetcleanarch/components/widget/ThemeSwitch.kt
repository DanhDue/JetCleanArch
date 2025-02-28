package com.danhdue.jetcleanarch.components.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SwitchCompat
import com.danhdue.jetcleanarch.theme.R

class ThemeSwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : SwitchCompat(context, attrs) {

    init {
        thumbDrawable = AppCompatResources.getDrawable(context, R.drawable.selector_dark_light)
        trackDrawable = AppCompatResources.getDrawable(context, R.drawable.selector_bg_dark_light)
    }
}