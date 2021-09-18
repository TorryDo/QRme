package com.torrydo.qrme.view

import android.content.ClipboardManager
import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import com.torrydo.qrme.R
import com.torrydo.qrme.databinding.QrViewBinding
import com.torrydo.qrme.utils.toQrBitmap
import android.content.Context.CLIPBOARD_SERVICE
import android.util.Log
import androidx.core.widget.doOnTextChanged
import com.torrydo.qrme.utils.Utils


class FloatingQRView(
    private val context: Context,
    private val windowManager: WindowManager
) {

    private var viewParams: WindowManager.LayoutParams? = null
    private var binding: QrViewBinding? = null

    init{
        setup()
        binding = QrViewBinding.inflate(LayoutInflater.from(context))
        initViewLayoutParams()
        config()
    }

    fun setup(){
        viewParams = WindowManager.LayoutParams()
    }

    fun config(){

        binding!!.qrviewBackicon.setOnClickListener {
            removeView()
        }

        binding!!.qrviewEdittext.doOnTextChanged { text, start, before, count ->
            binding!!.qrviewImage.setImageBitmap(text.toString().toQrBitmap())
        }
    }

    fun addView() {
        windowManager.addView(binding!!.root, viewParams)

        val clipboard = Utils.getLastestClipboard(context)
        binding!!.qrviewImage.setImageBitmap(clipboard.toQrBitmap())
        binding!!.qrviewEdittext.setText(clipboard)

    }
    fun removeView() = windowManager.removeView(binding!!.root)
    fun updateView() = windowManager.updateViewLayout(binding!!.root, viewParams)

    private fun initViewLayoutParams() {
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