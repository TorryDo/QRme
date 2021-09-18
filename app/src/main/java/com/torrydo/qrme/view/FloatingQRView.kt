package com.torrydo.qrme.view

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import com.torrydo.qrme.R
import com.torrydo.qrme.databinding.QrViewBinding

class FloatingQRView(
    private val context: Context,
    private val windowManager: WindowManager
) {

    private var viewParams: WindowManager.LayoutParams? = null

    private var binding = QrViewBinding.inflate(LayoutInflater.from(context))

    fun addView() = windowManager.addView(binding.root, viewParams)
    fun removeView() = windowManager.removeView(binding.root)
    fun updateView() = windowManager.updateViewLayout(binding.root, viewParams)


    fun initViewLayoutParams() {
        viewParams?.apply {
            width = WindowManager.LayoutParams.WRAP_CONTENT
            height = WindowManager.LayoutParams.WRAP_CONTENT

            gravity = Gravity.CENTER
            format = PixelFormat.TRANSLUCENT
            type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                // use for android version lower than 8
                WindowManager.LayoutParams.TYPE_PHONE
            }

            viewParams?.apply {
                width = WindowManager.LayoutParams.MATCH_PARENT
                gravity = Gravity.TOP
                flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
                dimAmount = 0.5f
                softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
                windowAnimations = R.style.TransViewStyle
            }
        }

    }
}