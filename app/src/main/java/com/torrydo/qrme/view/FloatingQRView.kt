package com.torrydo.qrme.view

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.view.*
import androidx.annotation.RequiresApi
import androidx.core.widget.doOnTextChanged
import com.torrydo.qrme.R
import com.torrydo.qrme.databinding.QrViewBinding
import com.torrydo.qrme.utils.Utils
import com.torrydo.qrme.utils.toQrBitmap


class FloatingQRView(
    private val context: Context,
    private val windowManager: WindowManager
) {

    private var viewParams: WindowManager.LayoutParams? = null
    private var binding: QrViewBinding? = null

    init {
        setup()
        initViewLayoutParams()
        config()
    }

    fun setup() {
        viewParams = WindowManager.LayoutParams()
        binding = QrViewBinding.inflate(LayoutInflater.from(context))
    }

    fun config() {


        binding!!.qrviewBackicon.setOnClickListener {
            removeView()
        }

        binding!!.qrviewEdittext.doOnTextChanged { text, start, before, count ->
            binding!!.qrviewImage.setImageBitmap(text.toString().toQrBitmap())
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun addView() {
        windowManager.addView(binding!!.root, viewParams)

        binding!!.qrviewEdittext.requestFocus()

        binding!!.root.requestFocusFromTouch()
        binding!!.qrviewEdittext.isFocusableInTouchMode = true

//        binding!!.qrviewEdittext.setOnFocusChangeListener { view, b ->
//            if(b){
//                val clipboard = Utils.getLastestClipboard(context)
//                binding!!.qrviewImage.setImageBitmap(clipboard.toQrBitmap())
//                binding!!.qrviewEdittext.setText(clipboard)
//            }
//            context.showShortToast("Dit m3 cuoc doi")
//        }
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