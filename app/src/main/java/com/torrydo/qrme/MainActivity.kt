package com.torrydo.qrme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.torrydo.qrme.databinding.ActivityMainBinding
import com.torrydo.qrme.utils.Utils
import com.torrydo.qrme.utils.toQrBitmap


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setup()
        onclick()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            Utils.showKeyboard(this, binding!!.edittext)

            Utils.getLastestClipboard(this).let {
                binding!!.edittext.setText(it)
            }
        } else {
            Utils.hideKeyboard(this, binding!!.edittext)
        }

        super.onWindowFocusChanged(hasFocus)
    }

    private fun onclick() {

        binding!!.backicon.setOnClickListener {
            finish()
            Utils.hideKeyboard(this, binding!!.edittext)
        }

        binding!!.buttonPaste.setOnClickListener {
            binding!!.edittext.setText(Utils.getLastestClipboard(this))
        }
        binding!!.buttonClear.setOnClickListener {
            binding!!.edittext.setText("")
        }
    }

    private fun setup() {

        binding!!.edittext.doOnTextChanged { text, start, before, count ->

            binding!!.image.setImageBitmap(text.toString().toQrBitmap())
        }

    }
}