package com.github.heesung6701.donedonetest

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.withStyledAttributes
import com.github.heesung6701.donedonetest.ui.WaffleButton

class WaffleViewInflater : AppCompatViewInflater() {

    override fun createButton(context: Context, attrs: AttributeSet?): AppCompatButton {
        return WaffleButton(context, attrs)
    }

    override fun createView(context: Context?, name: String?, attrs: AttributeSet?): View? {
        return super.createView(context, name, attrs)
    }
}