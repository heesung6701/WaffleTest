package com.github.heesung6701.donedonetest.ui

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.withStyledAttributes
import com.github.heesung6701.donedonetest.R

class WaffleButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : AppCompatButton(context.applyWaffleStyle(attrs), attrs, defStyleAttr) {

    companion object {
        fun Context.applyWaffleStyle(attrs: AttributeSet?): Context {
            var styleRes: Int? = null
            withStyledAttributes(
                set = attrs,
                attrs = R.styleable.WaffleButton,
                defStyleAttr = androidx.appcompat.R.attr.buttonStyle,
                defStyleRes = R.style.Waffle_Button
            ) {
                val viewStyle = getInt(R.styleable.WaffleButton_waffleButtonStyle, 0)
                styleRes = WaffleViewStyle.getWaffleViewStyle(viewStyle).styleResId
            }
            return styleRes?.let { ContextThemeWrapper(this, it) } ?: this
        }
    }

    init {
    }

    data class WaffleViewModel(val checked: Boolean)

    sealed class WaffleViewStyle(val styleResId: Int) {

        companion object {
            private val styles = listOf(DefaultViewStyle(), PrimaryViewStyle(), NegativeViewStyle())
            fun getWaffleViewStyle(viewStyle: Int): WaffleViewStyle = styles[viewStyle]
        }
    }

    class DefaultViewStyle() : WaffleViewStyle(R.style.Waffle_Button)
    class PrimaryViewStyle() : WaffleViewStyle(R.style.Waffle_Button_Primary)
    class NegativeViewStyle() : WaffleViewStyle(R.style.Waffle_Button_Negative)
}
