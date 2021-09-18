package com.torrydo.qrme

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.torrydo.qrme.databinding.ActivityMainBinding
import com.torrydo.qrme.utils.toQrBitmap

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.button.setOnClickListener {

            val value = binding!!.edittext.text.toString()

            binding!!.imageView.setImageBitmap(value.toQrBitmap())
        }

    }
}