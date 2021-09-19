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

    private fun onclick() {
        binding!!.image.setOnLongClickListener {
            Utils.getLastestClipboard(this).let {
                binding!!.edittext.setText(it)
            }
            true
        }
    }

    private fun setup() {
        binding!!.edittext.requestFocusFromTouch()
        binding!!.root.requestFocusFromTouch()

        binding!!.backicon.setOnClickListener {
            finish()
        }

        binding!!.edittext.doOnTextChanged { text, start, before, count ->
            binding!!.image.setImageBitmap(text.toString().toQrBitmap())
        }

        Utils.getLastestClipboard(this).let {
            binding!!.edittext.setText(it)
        }

    }
}