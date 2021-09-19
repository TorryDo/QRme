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

        binding!!.backicon.setOnClickListener {
            finish()
        }

        binding!!.image.setImageBitmap(Utils.getLastestClipboard(this).toQrBitmap())

        binding!!.edittext.doOnTextChanged { text, start, before, count ->
            binding!!.image.setImageBitmap(text.toString().toQrBitmap())
        }

    }

    private fun setup() {

    }
}