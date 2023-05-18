package com.github.heesung6701.donedonetest.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.github.heesung6701.donedonetest.R

class WaffleView : View {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, R.style.Waffle_Button)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        R.style.Waffle_Button
    )

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        val waffleViewStyle: WaffleViewStyle
        context.obtainStyledAttributes(attrs, R.styleable.WaffleView, defStyleAttr, defStyleRes)
            .use {
                val viewStyle = it.getInt(R.styleable.WaffleView_waffleViewStyle, 0)
                waffleViewStyle = WaffleViewStyle.getWaffleViewStyle(viewStyle)
            }

        context.theme.applyStyle(waffleViewStyle.styleResId, true)
    }

    data class WaffleViewModel(val checked: Boolean)

    sealed class WaffleViewStyle(val styleResId: Int) {

        companion object {
            private val styles = listOf(PrimaryViewStyle(), NegativeViewStyle())
            fun getWaffleViewStyle(viewStyle: Int): WaffleViewStyle = styles[viewStyle]
        }
    }

    class PrimaryViewStyle() : WaffleViewStyle(R.style.Waffle_Button_Primary)
    class NegativeViewStyle() : WaffleViewStyle(R.style.Waffle_Button_Negative)

}